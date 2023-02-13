package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @GetMapping(value="/usuario")
    public String exibirTelaCadastro() {
        return "usuario/cadastro";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Usuario usuario) {
        System.out.println("Inclusão realizada com sucesso: " + usuario);
        return "redirect:/";
    }
}
