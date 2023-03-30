package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Log;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import br.edu.infnet.gerenciadorpersonagens.model.service.EntityServices;
import br.edu.infnet.gerenciadorpersonagens.model.service.LogService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Objects;

@Controller
public class AppController {

    private final AuthService authService;
    private final EntityServices entityServices;
    private final LogService logService;

    @Autowired
    public AppController(AuthService authService, EntityServices entityServices, LogService logService) {
        this.authService = authService;
        this.entityServices = entityServices;
        this.logService = logService;
    }

    @GetMapping(value = "/")
    public String exibirTelaIndex(HttpSession session, Model model) {
        if (!authService.isLoggedIn(session)) {
            return "redirect:/login";
        }
        else {
            Collection<Log> listaLogs;
            if (Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
                listaLogs = logService.obterListaPorUsuario(((Criador) authService.getSessionObject(session)).getId());
                model.addAttribute("listaLogs", listaLogs);
                model.addAttribute("listaPersonagens", entityServices.personagemService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()));
                model.addAttribute("listaPersonalidades", entityServices.personalidadeService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()));
                model.addAttribute("listaHabilidades", entityServices.habilidadeService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()));
                model.addAttribute("listaAparencias", entityServices.aparenciaService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()));
            }
            else if (Objects.equals(authService.getLoggedUserType(session), authService.adminUser)) {
                listaLogs = logService.obterLista();
                model.addAttribute("listaLogs", listaLogs);
                model.addAttribute("listaPersonagens", entityServices.personagemService.obterLista());
                model.addAttribute("listaPersonalidades", entityServices.personalidadeService.obterLista());
                model.addAttribute("listaHabilidades", entityServices.habilidadeService.obterLista());
                model.addAttribute("listaAparencias", entityServices.aparenciaService.obterLista());
                model.addAttribute("listaCriadores", entityServices.criadorService.obterLista());
                model.addAttribute("listaAdministradores", entityServices.adminService.obterLista());
            }
            return "index";
        }
    }

    /*
    @GetMapping(value = "/home")
    public String exibirTelaHome() {
        return "index";
    }

     */

}
