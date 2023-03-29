package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import br.edu.infnet.gerenciadorpersonagens.model.service.EntityServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Controller
public class AppController {

    private final AuthService authService;
    private final EntityServices entityServices;

    @Autowired
    public AppController(AuthService authService, EntityServices entityServices) {
        this.authService = authService;
        this.entityServices = entityServices;
    }

    @GetMapping(value = "/")
    public String exibirTelaIndex(HttpSession session, Model model) {
        if (!authService.isLoggedIn(session)) {
            return "redirect:/login";
        }
        else {
            if (Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
                model.addAttribute("listaPersonagens", entityServices.personalidadeService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()));
                model.addAttribute("listaPersonalidades", entityServices.personalidadeService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()));
                model.addAttribute("listaHabilidades", entityServices.habilidadeService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()));
                model.addAttribute("listaAparencias", entityServices.aparenciaService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId()));
            }
            else if (Objects.equals(authService.getLoggedUserType(session), authService.adminUser)) {
                model.addAttribute("listaPersonagens", entityServices.personalidadeService.obterLista());
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
