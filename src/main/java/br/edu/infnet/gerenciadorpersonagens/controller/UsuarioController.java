package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario;
import br.edu.infnet.gerenciadorpersonagens.model.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class UsuarioController {

    private static String msg;

    @GetMapping(value="/usuario")
    public String exibirTelaCadastro() {
        return "usuario/cadastro";
    }

    @GetMapping(value="/usuario/lista")
    public String exibirTelaLista(Model model) {

        Collection<Usuario> lista = UsuarioRepository.obterLista();

        model.addAttribute("listaUsuarios", lista);
        model.addAttribute("mensagemInclusao", msg);

        msg = null;

        return "usuario/lista";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Usuario usuario) {
        System.out.println("Inclusão realizada com sucesso: " + usuario);

        UsuarioRepository.incluir(usuario);

        msg = "Usuário " + usuario.getNomeCompleto() + " incluído com sucesso!";

        return "redirect:/usuario/lista";
    }

    @GetMapping(value = "/usuario/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        Usuario usuario = UsuarioRepository.excluir(id);
        msg = "Usuário " + usuario.getNomeCompleto() + " excluído com sucesso!";
        return "redirect:/usuario/lista";
    }
}
