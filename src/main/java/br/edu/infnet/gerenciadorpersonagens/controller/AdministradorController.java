package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Administrador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Log;
import br.edu.infnet.gerenciadorpersonagens.model.service.AdministradorService;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import br.edu.infnet.gerenciadorpersonagens.model.service.LogService;
import jakarta.servlet.http.HttpServletRequest;
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
public class AdministradorController {

    private final AdministradorService administradorService;
    private final AuthService authService;
    private final LogService logService;
    private static String msg;

    @Autowired
    public AdministradorController(AdministradorService administradorService, AuthService authService, LogService logService) {
        this.administradorService = administradorService;
        this.authService = authService;
        this.logService = logService;
    }

    @GetMapping(value = "/administrador/cadastro")
    public String exibirTelaCadastro(HttpSession session){
        if (!Objects.equals(authService.getLoggedUserType(session), authService.adminUser)) {
            return "redirect:/login";
        }
        else {
            return "/administrador/cadastro";
        }
    }

    @PostMapping(value = "/administrador/incluir")
    public String incluir(HttpSession session, Administrador administrador, HttpServletRequest request) {
        if (!Objects.equals(authService.getLoggedUserType(session), authService.adminUser)) {
            return "redirect:/login";
        }
        Administrador admLogado = (Administrador) authService.getSessionObject(session);

        administradorService.incluir(administrador);

        String msgLog = "Cadastrado Administrador " + administrador.getNomeCompleto() + " com id " + administradorService.obterPorId(administrador.getId()).getId();

        Log log = new Log(request.getRemoteAddr(), Utils.TIPO_ACAO_LOG[0], msgLog, admLogado);
        logService.incluir(log);

        return "redirect:/administrador/lista";
    }

    @GetMapping(value = "/administrador/lista")
    public String exibirLista(HttpSession session, Model model) {

        Collection<Administrador> lista;
        if (!(authService.isLoggedIn(session) || Objects.equals(authService.getSessionObject(session), authService.adminUser))) {
            return "redirect:/login";
        }
        else  {
            lista = administradorService.obterLista();
        }
        model.addAttribute("listaAdministrador", lista);
        model.addAttribute("mensagemInclusao", msg);
        return "/administrador/lista";
    }

    @GetMapping(value = "administrador/{id}/excluir")
    public String excluir(@PathVariable Integer id, HttpSession session, HttpServletRequest request) {
        Administrador admLogado = (Administrador) authService.getSessionObject(session);

        Administrador adm = administradorService.obterPorId(id);
        administradorService.excluir(id);

        String msgLog = "Excluído Administrador " + adm.getNomeCompleto() + " com id " + adm.getId();
        Log log = new Log(request.getRemoteAddr(), Utils.TIPO_ACAO_LOG[1], msgLog, admLogado);
        logService.incluir(log);

        msg = "Administrador " + id + " excluída com sucesso!";
        return "redirect:/administrador/lista";
    }
}
