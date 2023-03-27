package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Administrador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario;
import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import br.edu.infnet.gerenciadorpersonagens.model.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("usuario")
public class AcessoController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private AuthService authService;

    @GetMapping(value="/login")
    public String exibirTelaLogin() {
        return "login";
    }

    @PostMapping(value="/login")
    public String login(Usuario usuario, Model model) {

        Usuario userToLogin = usuarioService.autenticar(usuario);
        if (userToLogin != null) {

            if (userToLogin instanceof Administrador admin) {
                System.out.println("Administrador logado: " + admin);
                model.addAttribute("usuario", admin);
            }
            else if (userToLogin instanceof Criador criador) {
                System.out.println("Criador logado: " + criador);
                model.addAttribute("usuario", criador);
            }
            else {
                System.out.println("Usuário logado: " + userToLogin);
                model.addAttribute("usuario", userToLogin);
            }
            return "redirect:/";

        } else {
            model.addAttribute("mensagem", "As credenciais para o email " + usuario.getEmail() + " não batem!");
            return exibirTelaLogin();
        }
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status) {
        authService.logout(session, status);
        return "redirect:/login";
    }
}
