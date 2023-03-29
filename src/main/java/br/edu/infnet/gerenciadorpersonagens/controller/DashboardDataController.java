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
            if (authService.getLoggedUserType(session).equals(authService.criadorUser)) {

                int quantityPersonalidades = entityServices.personalidadeService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()).size();
                int quantityHabilidades = entityServices.habilidadeService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()).size();
                int quantityAparencias = entityServices.aparenciaService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()).size();
                int quantityPersonagens = entityServices.personalidadeService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()).size();
                int quantityCriadores = 0;
                int quantityAdministradores = 0;

                HashMap<String, String> mapQuantidades = new HashMap<>();
                    mapQuantidades.put("quantityPersonalidades", Integer.toString(quantityPersonalidades));
                    mapQuantidades.put("quantityHabilidades", Integer.toString(quantityHabilidades));
                    mapQuantidades.put("quantityAparencias", Integer.toString(quantityAparencias));
                    mapQuantidades.put("quantityPersonagens", Integer.toString(quantityPersonagens));
                    mapQuantidades.put("quantityCriadores", Integer.toString(quantityCriadores));
                    mapQuantidades.put("quantityAdministradores", Integer.toString(quantityAdministradores));

                return gson.toJson(mapQuantidades);
            }
            if (authService.getLoggedUserType(session).equals(authService.adminUser)) {

                int quantityPersonalidades = entityServices.personalidadeService.obterLista().size();
                int quantityHabilidades = entityServices.habilidadeService.obterLista().size();
                int quantityAparencias = entityServices.aparenciaService.obterLista().size();
                int quantityPersonagens = entityServices.personalidadeService.obterLista().size();
                int quantityCriadores = entityServices.criadorService.obterLista().size();
                int quantityAdministradores = entityServices.adminService.obterLista().size();

                HashMap<String, String> mapQuantidades = new HashMap<>();
                    mapQuantidades.put("quantityPersonalidades", Integer.toString(quantityPersonalidades));
                    mapQuantidades.put("quantityHabilidades", Integer.toString(quantityHabilidades));
                    mapQuantidades.put("quantityAparencias", Integer.toString(quantityAparencias));
                    mapQuantidades.put("quantityPersonagens", Integer.toString(quantityPersonagens));
                    mapQuantidades.put("quantityCriadores", Integer.toString(quantityCriadores));
                    mapQuantidades.put("quantityAdministradores", Integer.toString(quantityAdministradores));

                return gson.toJson(mapQuantidades);
            }
        }
        return null;
    }
}
