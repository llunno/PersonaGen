package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Log;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Personagem;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Personalidade;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import br.edu.infnet.gerenciadorpersonagens.model.service.LogService;
import br.edu.infnet.gerenciadorpersonagens.model.service.PersonalidadeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Controller
public class PersonalidadeController {

    private final PersonalidadeService personalidadeService;
    private final AuthService authService;
    private final LogService logService;
    private static String msg;

    @Autowired
    public PersonalidadeController(PersonalidadeService personalidadeService, AuthService authService, LogService logService) {
        this.personalidadeService = personalidadeService;
        this.authService = authService;
        this.logService = logService;
    }

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
    public String incluir(HttpSession session, Personalidade personalidade, HttpServletRequest request) {
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            return "redirect:/login";
        }
        Criador criadorLogado = (Criador) authService.getSessionObject(session);

        personalidade.setCriador((Criador) authService.getSessionObject(session));
        personalidadeService.incluir(personalidade);

        String msgLog = "Cadastrada personalidade " + personalidade.getPalavraDefinicao() + " com id " + personalidadeService.obterPorId(personalidade.getId()).getId();

        Log log = new Log(request.getRemoteAddr(), Utils.TIPO_ACAO_LOG[0], msgLog, criadorLogado);
        logService.incluir(log);

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
        msg = null;
        return "/personalidade/lista";
    }

    @Transactional
    @GetMapping(value = "personalidade/{id}/excluir")
    public String excluir(@PathVariable Integer id, HttpSession session, HttpServletRequest request) {
        if (!authService.isLoggedIn(session)) {
            return "redirect:/login";
        }
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            msg = "Você não tem permissão para excluir uma Personalidade! Entre como um criador para isto.";
            return "redirect:/personalidade/lista";
        }
        Criador criadorLogado = (Criador) authService.getSessionObject(session);

        Personalidade personalidade = personalidadeService.obterPorId(id);

        if (personalidade.getPersonagens() != null && !personalidade.getPersonagens().isEmpty()) {
            msg = "Não é possível excluir uma personalidade que está associada a um personagem!";
            return "redirect:/personalidade/lista";
        }

        personalidadeService.excluir(id);

        List<Personagem> personagensAssociados = personalidade.getPersonagens();
        for (Personagem personagem : personagensAssociados) {
            personagem.getCaracteristicas().remove(personalidade);
        }

        String msgLog = "Excluída personalidade " + personalidade.getPalavraDefinicao() + " com id " + personalidade.getId();
        Log log = new Log(request.getRemoteAddr(), Utils.TIPO_ACAO_LOG[1], msgLog, criadorLogado);
        logService.incluir(log);

        msg = "Personalidade " + personalidade.getId() + " excluída com sucesso!";
        return "redirect:/personalidade/lista";
    }

}
