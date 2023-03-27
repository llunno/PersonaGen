package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Administrador;
import br.edu.infnet.gerenciadorpersonagens.model.service.AdministradorService;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Objects;

@Controller
public class AdministradorController {

    @Autowired
    AdministradorService administradorService;
    @Autowired
    private AuthService authService;

    private static String msg;

    @GetMapping(value = "/administrador/cadastro")
    public String exibirTelaCadastro(HttpSession session){
        if (!Objects.equals(authService.getLoggedUserType(session), authService.adminUser)) {
            return "redirect:/login";
        }
        else {
            return "/administrador/cadastro";
        }
    }

    @PostMapping(value = "/administrador/incluir")
    public String incluir(HttpSession session, Administrador administrador) {
        if (!Objects.equals(authService.getLoggedUserType(session), authService.adminUser)) {
            return "redirect:/login";
        }
        administradorService.incluir(administrador);
        return "redirect:/administrador/lista";
    }

    @GetMapping(value = "/administrador/lista")
    public String exibirLista(HttpSession session, Model model) {

        Collection<Administrador> lista;
        if (!(authService.isLoggedIn(session) || Objects.equals(authService.getSessionObject(session), authService.adminUser))) {
            return "redirect:/login";
        }
        else  {
            lista = administradorService.obterLista();
        }
        model.addAttribute("listaAdministrador", lista);
        model.addAttribute("mensagemInclusao", msg);
        return "/administrador/lista";
    }

    @GetMapping(value = "administrador/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        administradorService.excluir(id);
        msg = "Administrador " + id + " excluída com sucesso!";
        return "redirect:/administrador/lista";
    }
}
