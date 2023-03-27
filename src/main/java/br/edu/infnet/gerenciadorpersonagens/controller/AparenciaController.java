package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Aparencia;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.service.AparenciaService;
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
public class AparenciaController {

    @Autowired
    private AparenciaService aparenciaService;
    @Autowired
    private AuthService authService;

    private static String msg;

    @GetMapping(value = "/aparencia/cadastro")
    public String exibirTelaCadastro(HttpSession session){
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            return "redirect:/login";
        }
        else {
            return "/aparencia/cadastro";
        }
    }

    @PostMapping(value = "/aparencia/incluir")
    public String incluir(HttpSession session, Aparencia aparencia) {
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            return "redirect:/login";
        }
        aparencia.setCriador((Criador) authService.getSessionObject(session));
        aparenciaService.incluir(aparencia);
        msg = "Aparência " + aparencia.getId() + " incluida com sucesso!";
        return "redirect:/aparencia/lista";
    }

    @GetMapping(value = "/aparencia/lista")
    public String exibirLista(HttpSession session, Model model) {
        Collection<Aparencia> lista;
        if (!authService.isLoggedIn(session)) {
            return "redirect:/login";
        }

        if (Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            lista = aparenciaService.obterListaPorCriador(((Criador) authService.getSessionObject(session)).getId());
        }
        else  {
            lista = aparenciaService.obterLista();
        }
        model.addAttribute("listaAparencia", lista);
        model.addAttribute("mensagemInclusao", msg);
        return "/aparencia/lista";
    }

    @GetMapping(value = "aparencia/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        Aparencia aparencia = aparenciaService.obterPorId(id);
        aparenciaService.excluir(id);
        msg = "Aparência " + aparencia.getId() + " excluída com sucesso!";
        return "redirect:/aparencia/lista";
    }
}
