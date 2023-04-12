package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Administrador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Log;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import br.edu.infnet.gerenciadorpersonagens.model.service.LogService;
import br.edu.infnet.gerenciadorpersonagens.model.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class AcessoController {

    private final UsuarioService usuarioService;
    private final AuthService authService;
    private final LogService logService;
    private static String msg;

    @Autowired
    public AcessoController(UsuarioService usuarioService, AuthService authService, LogService logService) {
        this.usuarioService = usuarioService;
        this.authService = authService;
        this.logService = logService;
    }

    @GetMapping(value="/login")
    public String exibirTelaLogin() {
        return "login";
    }

    @PostMapping(value="/login")
    public String login(Usuario usuario, Model model, HttpServletRequest request, HttpSession session) {

        Usuario userToLogin = authService.autenticar(usuario);
        if (userToLogin != null) {
            if (userToLogin instanceof Administrador admin) {
                System.out.println("Administrador logado: " + admin);
                model.addAttribute("usuario", admin);
                session.setAttribute("usuario", admin);
            }
            else if (userToLogin instanceof Criador criador) {
                System.out.println("Criador logado: " + criador);
                model.addAttribute("usuario", criador);
                session.setAttribute("usuario", criador);
            }
            else {
                System.out.println("Usuário logado: " + userToLogin);
                model.addAttribute("usuario", userToLogin);
                session.setAttribute("usuario", userToLogin);
            }

            String msgLog = "Efetuado login como " + userToLogin.getNomeCompleto() + " com id " + usuarioService.obterPorId(userToLogin.getId()).getId();

            Log log = new Log(request.getRemoteAddr(), Utils.TIPO_ACAO_LOG[3], msgLog, userToLogin);
            logService.incluir(log);

            return "redirect:/";
        } else {
            msg = "As credenciais para o email " + usuario.getEmail() + " são inválidas! Verifique o email ou senha e tente novamente.";
            model.addAttribute("mensagem", msg);
            msg = null;
            return "/login";
        }
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status, HttpServletRequest request) {
        Usuario usuarioLogado = (Usuario) authService.getSessionObject(session);

        String msgLog = "Efetuado logout como " + usuarioLogado.getNomeCompleto() + " com id " + usuarioLogado.getId();
        Log log = new Log(request.getRemoteAddr(), Utils.TIPO_ACAO_LOG[4], msgLog, usuarioLogado);
        logService.incluir(log);

        authService.logout(session, status);

        return "redirect:/login";
    }
}
