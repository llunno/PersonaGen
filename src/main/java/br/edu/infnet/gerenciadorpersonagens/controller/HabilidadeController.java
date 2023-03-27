package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Habilidade;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import br.edu.infnet.gerenciadorpersonagens.model.service.HabilidadeService;
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

@Controller
@RequestMapping(value = "/habilidade")
public class HabilidadeController {

    @Autowired
    private HabilidadeService habilidadeService;
    @Autowired
    private AuthService authService;
    private static String msg;

    @GetMapping(value = "/cadastro")
    public String exibirTelaCadastro(HttpSession session){
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            return "redirect:/login";
        }
        else {
            return "/habilidade/cadastro";
        }
    }

    @PostMapping(value = "/incluir")
    public String incluir(HttpSession session, Habilidade habilidade) {
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            return "redirect:/login";
        }
        habilidade.setCriador((Criador) authService.getSessionObject(session));
        habilidadeService.incluir(habilidade);
        msg = "Habilidade " + habilidade.getNome() + " incluida com sucesso!";
        return "redirect:/habilidade/lista";
    }

    @GetMapping(value = "/lista")
    public String exibirLista(HttpSession session, Model model) {

        Collection<Habilidade> lista;
        if (!authService.isLoggedIn(session)) {
            return "redirect:/login";
        }

        if (Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            lista = habilidadeService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId());
        }
        else  {
            lista = habilidadeService.obterLista();
        }

        model.addAttribute("listaHabilidades", lista);
        model.addAttribute("mensagemInclusao", msg);
        return "/habilidade/lista";
    }

    @GetMapping(value = "/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        Habilidade habilidade = habilidadeService.obterPorId(id);
        habilidadeService.excluir(id);
        msg = "Habilidade " + habilidade.getNome() + " excluída com sucesso!";
        return "redirect:/habilidade/lista";
    }
}
