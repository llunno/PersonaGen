package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils;
import br.edu.infnet.gerenciadorpersonagens.model.domain.*;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import br.edu.infnet.gerenciadorpersonagens.model.service.CaracteristicaService;
import br.edu.infnet.gerenciadorpersonagens.model.service.LogService;
import br.edu.infnet.gerenciadorpersonagens.model.service.PersonagemService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/personagem")
public class PersonagemController {

    private final PersonagemService personagemService;
    private final AuthService authService;
    private final LogService logService;
    private final CaracteristicaService caracteristicaService;
    private static String msg;

    @Autowired
    public PersonagemController(PersonagemService personagemService, AuthService authService, LogService logService, CaracteristicaService caracteristicaService) {
        this.personagemService = personagemService;
        this.authService = authService;
        this.logService = logService;
        this.caracteristicaService = caracteristicaService;
    }

    @GetMapping("/cadastro")
    public String exibirCadastro(HttpSession session, Model model) {
        if (!authService.isLoggedIn(session)) {
            return "redirect:/login";
        }
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            return "redirect:/login";
        }

        Integer criadorLogadoId = ((Criador) authService.getSessionObject(session)).getId();

        List<Caracteristica> listaCaracteristicas = (List<Caracteristica>) caracteristicaService.obterListaPorCriador(criadorLogadoId);
        List<Caracteristica> listaPersonalidades = new ArrayList<>();
        List<Caracteristica> listaHabilidades = new ArrayList<>();
        List<Caracteristica> listaAparencias = new ArrayList<>();

        for (Caracteristica caracteristica : listaCaracteristicas) {
            if (caracteristica instanceof Personalidade) {
                listaPersonalidades.add(caracteristica);
            } else if (caracteristica instanceof Habilidade) {
                listaHabilidades.add(caracteristica);
            } else if (caracteristica instanceof Aparencia) {
                listaAparencias.add(caracteristica);
            }
        }


        model.addAttribute("listaPersonalidades", listaPersonalidades);
        model.addAttribute("listaHabilidades", listaHabilidades);
        model.addAttribute("listaAparencias", listaAparencias);

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
    public String incluir(HttpSession session, Personagem personagem, HttpServletRequest request) {
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            return "redirect:/login";
        }

        Criador criadorLogado = (Criador) authService.getSessionObject(session);

        personagem.setCriador(criadorLogado);
        personagemService.incluir(personagem);

        String msgLog = "Cadastrado personagem " + personagem.getNome() + " com id " + personagemService.obterPorId(personagem.getId()).getId();

        Log log = new Log(request.getRemoteAddr(), Utils.TIPO_ACAO_LOG[0], msgLog, criadorLogado);
        logService.incluir(log);

        msg = "Personagem " + personagem.getNome() + " incluida com sucesso!";
        return "redirect:/personagem/lista";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Integer id, HttpSession session, HttpServletRequest request) {

        if (!authService.isLoggedIn(session)) {
            return "redirect:/login";
        }
        if (!Objects.equals(authService.getLoggedUserType(session), authService.criadorUser)) {
            msg = "Você não tem permissão para excluir uma Aparência! Entre como um criador para isto.";
            return "redirect:/personagem/lista";
        }
        Criador criadorLogado = (Criador) authService.getSessionObject(session);

        Personagem personagem = personagemService.obterPorId(id);
        personagemService.excluir(id);

        String msgLog = "Excluído personagem " + personagem.getNome() + " com id " + personagem.getId();
        Log log = new Log(request.getRemoteAddr(), Utils.TIPO_ACAO_LOG[1], msgLog, criadorLogado);
        logService.incluir(log);

        msg = "Personagem " + personagem.getNome() + " excluída com sucesso!";
        return "redirect:/personagem/lista";
    }
}
