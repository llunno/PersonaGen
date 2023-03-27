package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Personalidade;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import br.edu.infnet.gerenciadorpersonagens.model.service.PersonalidadeService;
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
public class PersonalidadeController {

    @Autowired
    private PersonalidadeService personalidadeService;
    @Autowired
    private AuthService authService;

    private static String msg;

    @GetMapping(value = "/personalidade/cadastro")
    public String exibirTelaCadastro(HttpSession session){
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            return "redirect:/login";
        }
        else {
            return "/personalidade/cadastro";
        }
    }

    @PostMapping(value = "/personalidade/incluir")
    public String incluir(HttpSession session, Personalidade personalidade) {
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            return "redirect:/login";
        }
        personalidade.setCriador((Criador) authService.getSessionObject(session));
        personalidadeService.incluir(personalidade);
        msg = "Personalidade " + personalidade.getId() + " incluida com sucesso!";
        return "redirect:/personalidade/lista";
    }

    @GetMapping(value = "/personalidade/lista")
    public String exibirLista(HttpSession session, Model model) {
        Collection<Personalidade> lista;
        if (!authService.isLoggedIn(session)) {
            return "redirect:/login";
        }

        if (Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            lista = personalidadeService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId());
        }
        else  {
            lista = personalidadeService.obterLista();
        }
        model.addAttribute("listaPersonalidade", lista);
        model.addAttribute("mensagemInclusao", msg);
        return "/personalidade/lista";
    }

    @GetMapping(value = "personalidade/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        Personalidade personalidade = personalidadeService.obterPorId(id);
        personalidadeService.excluir(id);
        msg = "Personalidade " + personalidade.getId() + " excluída com sucesso!";
        return "redirect:/personalidade/lista";
    }

}
