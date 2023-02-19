package br.edu.infnet.gerenciadorpersonagens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @GetMapping(value = "/")
    public String exibirTelaIndex() {
        return "redirect:/login";
    }

    @GetMapping(value = "/home")
    public String exibirTelaHome() {
        return "index";
    }

}
