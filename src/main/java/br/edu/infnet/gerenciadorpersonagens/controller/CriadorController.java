package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import br.edu.infnet.gerenciadorpersonagens.model.service.CriadorService;
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
public class CriadorController {

    @Autowired
    private CriadorService criadorService;
    @Autowired
    private AuthService authService;

    private static String msg;

    @GetMapping(value = "/criador/cadastro")
    public String exibirTelaCadastro(HttpSession session) {
        if (!Objects.equals(authService.getLoggedUserType(session), authService.adminUser)) {
            return "redirect:/login";
        }
        else {
            return "/criador/cadastro";
        }
    }

    @GetMapping(value = "/criador/lista")
    public String exibirLista(HttpSession session, Model model) {
        Collection<Criador> lista;

        if (Objects.equals(authService.getLoggedUserType(session), authService.adminUser)) {
            lista = criadorService.obterLista();
        }
        else {
            return "redirect:/login";
        }

        model.addAttribute("listaCriadores", lista);
        model.addAttribute("mensagemInclusao", msg);
        return "/criador/lista";
    }

    @PostMapping(value = "/criador/incluir")
    public String incluir(Criador criador) {
        criadorService.incluir(criador);
        msg = "Criador " + criador.getNomeCompleto() + " incluido com sucesso!";
        return "redirect:/criador/lista";
    }

    @GetMapping(value = "/criador/{id}/excluir")
    public String excluir(HttpSession session,@PathVariable Integer id) {
        if (!(authService.isLoggedIn(session) && Objects.equals(authService.getLoggedUserType(session), authService.adminUser))) {
            return "redirect:/login";
        }
        Criador criador = criadorService.obterPorId(id);
        criadorService.excluir(id);
        msg = "Criador " + criador.getNomeCompleto() + " excluído com sucesso!";
        return "redirect:/criador/lista";
    }
}
