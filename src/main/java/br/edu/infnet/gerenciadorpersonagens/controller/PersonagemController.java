package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Personagem;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import br.edu.infnet.gerenciadorpersonagens.model.service.PersonagemService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/personagem")
public class PersonagemController {

    private final PersonagemService personagemService;
    private final AuthService authService;
    private static String msg;

    @Autowired
    public PersonagemController(PersonagemService personagemService, AuthService authService) {
        this.personagemService = personagemService;
        this.authService = authService;
    }

    @GetMapping("/cadastro")
    public String exibirCadastro(HttpSession session) {
        if (!authService.isLoggedIn(session)) {
            return "redirect:/login";
        }
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            return "redirect:/login";
        }
        return "/personagem/cadastro";
    }

    @GetMapping("/lista")
    public String exibirLista(HttpSession session, Model model) {

        Collection<Personagem> lista;
        if (!authService.isLoggedIn(session)) {
            return "redirect:/login";
        }

        if (Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            lista = personagemService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId());
        }
        else  {
            lista = personagemService.obterLista();
        }
        model.addAttribute("listaPersonagem", lista);
        model.addAttribute("mensagemInclusao", msg);
        return "/personagem/lista";
    }

    @PostMapping("/incluir")
    public String incluir(HttpSession session, Personagem personagem) {
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            return "redirect:/login";
        }
        personagem.setCriador((Criador) authService.getSessionObject(session));
        personagemService.incluir(personagem);
        msg = "Personagem " + personagem.getNome() + " incluida com sucesso!";
        return "redirect:/personagem/lista";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable UUID id) {
        Personagem personagem = personagemService.obterPorId(id);
        personagemService.excluir(id);
        msg = "Personagem " + personagem.getNome() + " excluída com sucesso!";
        return "redirect:/personagem/lista";
    }
}
