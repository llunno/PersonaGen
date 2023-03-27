package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private AuthService authService;

    @GetMapping(value = "/")
    public String exibirTelaIndex(HttpSession session) {
        if (!authService.isLoggedIn(session)) {
            return "redirect:/login";
        }
        else {
            return "index";
        }
    }

    /*
    @GetMapping(value = "/home")
    public String exibirTelaHome() {
        return "index";
    }

     */

}
