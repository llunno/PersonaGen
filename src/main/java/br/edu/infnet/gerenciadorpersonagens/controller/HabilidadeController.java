package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Habilidade;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Log;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Personagem;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import br.edu.infnet.gerenciadorpersonagens.model.service.HabilidadeService;
import br.edu.infnet.gerenciadorpersonagens.model.service.LogService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/habilidade")
public class HabilidadeController {

    private final HabilidadeService habilidadeService;
    private final AuthService authService;
    private final LogService logService;
    private static String msg;

    @Autowired
    public HabilidadeController(HabilidadeService habilidadeService, AuthService authService, LogService logService) {
        this.habilidadeService = habilidadeService;
        this.authService = authService;
        this.logService = logService;
    }

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
    public String incluir(HttpSession session, Habilidade habilidade, HttpServletRequest request) {
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            return "redirect:/login";
        }
        Criador criadorLogado = (Criador) authService.getSessionObject(session);

        habilidade.setCriador(criadorLogado);
        habilidadeService.incluir(habilidade);

        String msgLog = "Cadastrada habilidade " + habilidade.getNome() + " com id " + habilidadeService.obterPorId(habilidade.getId()).getId();

        Log log = new Log(request.getRemoteAddr(), Utils.TIPO_ACAO_LOG[0], msgLog, criadorLogado);
        logService.incluir(log);

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

    @Transactional
    @GetMapping(value = "/{id}/excluir")
    public String excluir(@PathVariable Integer id, HttpSession session, HttpServletRequest request) {
        if (!authService.isLoggedIn(session)) {
            return "redirect:/login";
        }
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            msg = "Você não tem permissão para excluir uma Habilidade! Entre como um criador para isto.";
            return "redirect:/habilidade/lista";
        }

        Criador criadorLogado = (Criador) authService.getSessionObject(session);

        Habilidade habilidade = habilidadeService.obterPorId(id);

        if (habilidade.getPersonagens() != null && !habilidade.getPersonagens().isEmpty()) {
            msg = "Não é possível excluir uma habilidade que está associada a um personagem!";
            return "redirect:/habilidade/lista";
        }

        List<Personagem> personagensAssociados = habilidade.getPersonagens();
        for (Personagem personagem : personagensAssociados) {
            personagem.getCaracteristicas().remove(habilidade);
        }

        habilidadeService.excluir(id);

        String msgLog = "Excluída habilidade " + habilidade.getNome() + " com id " + habilidade.getId();
        Log log = new Log(request.getRemoteAddr(), Utils.TIPO_ACAO_LOG[1], msgLog, criadorLogado);
        logService.incluir(log);

        msg = "Habilidade " + habilidade.getNome() + " excluída com sucesso!";

        return "redirect:/habilidade/lista";
    }
}
