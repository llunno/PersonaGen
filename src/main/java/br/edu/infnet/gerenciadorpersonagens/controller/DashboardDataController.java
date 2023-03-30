package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import br.edu.infnet.gerenciadorpersonagens.model.service.EntityServices;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardDataController {

    private final AuthService authService;
    private final EntityServices entityServices;

    @Autowired
    public DashboardDataController(AuthService authService, EntityServices entityServices) {
        this.authService = authService;
        this.entityServices = entityServices;
    }

    @GetMapping(value = "/all")
    public String getDashboardData(HttpSession session) {
        Gson gson = new Gson();
        if (authService.isLoggedIn(session)) {

            int quantityPersonalidades = 0;
            int quantityHabilidades = 0;
            int quantityAparencias = 0;
            int quantityPersonagens = 0;
            int quantityCriadores = 0;
            int quantityAdministradores = 0;

            if (authService.getLoggedUserType(session).equals(authService.criadorUser)) {

                quantityPersonalidades = entityServices.personalidadeService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()).size();
                quantityHabilidades = entityServices.habilidadeService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()).size();
                quantityAparencias = entityServices.aparenciaService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()).size();
                quantityPersonagens = entityServices.personagemService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()).size();

            }
            if (authService.getLoggedUserType(session).equals(authService.adminUser)) {

                quantityPersonalidades = entityServices.personalidadeService.obterLista().size();
                quantityHabilidades = entityServices.habilidadeService.obterLista().size();
                quantityAparencias = entityServices.aparenciaService.obterLista().size();
                quantityPersonagens = entityServices.personagemService.obterLista().size();
                quantityCriadores = entityServices.criadorService.obterLista().size();
                quantityAdministradores = entityServices.adminService.obterLista().size();

            }
            HashMap<String, String> mapQuantidades = new HashMap<>();
            mapQuantidades.put("quantityPersonalidades", Integer.toString(quantityPersonalidades));
            mapQuantidades.put("quantityHabilidades", Integer.toString(quantityHabilidades));
            mapQuantidades.put("quantityAparencias", Integer.toString(quantityAparencias));
            mapQuantidades.put("quantityPersonagens", Integer.toString(quantityPersonagens));
            mapQuantidades.put("quantityCriadores", Integer.toString(quantityCriadores));
            mapQuantidades.put("quantityAdministradores", Integer.toString(quantityAdministradores));

            return gson.toJson(mapQuantidades);
        }
        return null;
    }
}
