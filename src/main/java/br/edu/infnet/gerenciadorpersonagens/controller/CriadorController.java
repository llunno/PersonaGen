package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Endereco;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import br.edu.infnet.gerenciadorpersonagens.model.service.CriadorService;
import br.edu.infnet.gerenciadorpersonagens.model.service.LogService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Collection;
import java.util.Objects;

@Controller
public class CriadorController {

    private final CriadorService criadorService;
    private final AuthService authService;
    private final LogService logService;
    private static String msg;

    @Autowired
    public CriadorController(CriadorService criadorService, AuthService authService, LogService logService) {
        this.criadorService = criadorService;
        this.authService = authService;
        this.logService = logService;
    }

    @GetMapping(value = "/criador/cadastro")
    public String exibirTelaCadastro(HttpSession session, SessionStatus status) {
        if (authService.isLoggedIn(session) && !Objects.equals(authService.getLoggedUserType(session), null)) {
            return "redirect:/";
        }
        else {
            return "/criador/cadastro";
        }
    }

    @GetMapping(value = "/criador/lista")
    public String exibirLista(HttpSession session, Model model) {
        Collection<Criador> lista;

        if (Objects.equals(authService.getLoggedUserType(session), authService.adminUser)) {
            lista = criadorService.obterListaOrdenada();
        }
        else {
            return "redirect:/login";
        }

        model.addAttribute("listaCriadores", lista);
        model.addAttribute("mensagemInclusao", msg);
        return "/criador/lista";
    }

    @PostMapping(value = "/criador/incluir")
    public String incluir(Criador criador, Endereco endereco, HttpSession session, HttpServletRequest request) {
        criador.setEndereco(endereco);
        criadorService.incluir(criador);

        msg = "Criador " + criador.getNomeCompleto() + " incluido com sucesso!";
        return "redirect:/criador/lista";
    }

    @GetMapping(value = "/criador/{id}/excluir")
    public String excluir(HttpSession session,@PathVariable Integer id) {
        if (!(authService.isLoggedIn(session) || Objects.equals(authService.getLoggedUserType(session), authService.adminUser))) {
            return "redirect:/login";
        }

        Criador criador = criadorService.obterPorId(id);

        criadorService.excluir(id);
        msg = "Criador " + criador.getNomeCompleto() + " excluído com sucesso!";
        return "redirect:/criador/lista";
    }
}
