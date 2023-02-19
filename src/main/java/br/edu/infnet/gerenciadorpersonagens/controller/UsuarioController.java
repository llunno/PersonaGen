package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario;
import br.edu.infnet.gerenciadorpersonagens.model.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {

    @GetMapping(value="/usuario")
    public String exibirTelaCadastro() {
        return "usuario/cadastro";
    }

    @GetMapping(value="/usuario/lista")
    public String exibirTelaLista() {

        List<Usuario> lista = UsuarioRepository.obterLista();

        System.out.println("Quantidade de usuários: " + lista.size());

        for (Usuario usuario : lista) {
            System.out.println("A inclusão do usuário " + usuario.getNomeCompleto() + "foi realizada com sucesso!");
        }

        return "usuario/lista";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Usuario usuario) {
        System.out.println("Inclusão realizada com sucesso: " + usuario);

        UsuarioRepository.incluir(usuario);

        return "redirect:/usuario/lista";
    }


}
