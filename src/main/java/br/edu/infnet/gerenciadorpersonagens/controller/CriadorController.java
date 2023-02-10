package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CriadorController {

    @GetMapping(value="/usuario")
    public String exibirTelaCadastro() {
        return "criador/cadastro";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Criador criador) {
        System.out.println("Inclusão realizada com sucesso: " + criador);
        return "redirect:/";
    }

}
