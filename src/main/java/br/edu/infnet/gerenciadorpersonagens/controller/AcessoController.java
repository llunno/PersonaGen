package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario;
import br.edu.infnet.gerenciadorpersonagens.model.repository.AcessoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AcessoController {
    @GetMapping(value="/login")
    public String exibirTelaLogin() {
        return "login";
    }

    @PostMapping(value="/login")
    public String login(Usuario usuario) {

        Usuario usuario1 = new Usuario(usuario.getEmail(), usuario.getSenha());

        if (AcessoRepository.autenticar(usuario1) != null) {
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }
    }

}
