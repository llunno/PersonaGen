package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Aparencia;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Log;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Personagem;
import br.edu.infnet.gerenciadorpersonagens.model.service.AparenciaService;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
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

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Controller
public class AparenciaController {

    private final AparenciaService aparenciaService;
    private final AuthService authService;
    private final LogService logService;

    private static String msg;

    @Autowired
    public AparenciaController(LogService logService, AparenciaService aparenciaService, AuthService authService) {
        this.logService = logService;
        this.aparenciaService = aparenciaService;
        this.authService = authService;
    }

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
    public String incluir(HttpSession session, Aparencia aparencia, HttpServletRequest request) {
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            return "redirect:/login";
        }
        Criador criadorLogado = (Criador) authService.getSessionObject(session);

        aparencia.setCriador((Criador) authService.getSessionObject(session));
        aparenciaService.incluir(aparencia);

        String msgLog = "Cadastrada Aparência " + aparencia.getPontoDeDestaque() + " com id " + aparenciaService.obterPorId(aparencia.getId()).getId();

        Log log = new Log(request.getRemoteAddr(), Utils.TIPO_ACAO_LOG[0], msgLog, criadorLogado);
        logService.incluir(log);

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

    @Transactional
    @GetMapping(value = "aparencia/{id}/excluir")
    public String excluir(@PathVariable Integer id, HttpSession session, HttpServletRequest request) {
        if (!authService.isLoggedIn(session)) {
            return "redirect:/login";
        }
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            msg = "Você não tem permissão para excluir uma Aparência! Entre como um criador para isto.";
            return "redirect:/aparencia/lista";
        }
        Criador criadorLogado = (Criador) authService.getSessionObject(session);

        Aparencia aparencia = aparenciaService.obterPorId(id);

        List<Personagem> personagensAssociados = aparencia.getPersonagens();
        for (Personagem personagem : personagensAssociados) {
            personagem.getCaracteristicas().remove(aparencia);
        }

        aparenciaService.excluir(id);

        String msgLog = "Excluída Aparência " + aparencia.getPontoDeDestaque() + " com id " + aparencia.getId();
        Log log = new Log(request.getRemoteAddr(), Utils.TIPO_ACAO_LOG[1], msgLog, criadorLogado);
        logService.incluir(log);

        msg = "Aparência " + aparencia.getId() + " excluída com sucesso!";
        return "redirect:/aparencia/lista";
    }
}
