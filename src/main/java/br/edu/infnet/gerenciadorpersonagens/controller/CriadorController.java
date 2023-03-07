package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.repository.CriadorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class CriadorController {

    private static String msg;

    @GetMapping(value = "/criador/cadastro")
    public void exibirTelaCadastro() {}

    @GetMapping(value = "/criador/lista")
    public String exibirLista(Model model) {

        Collection<Criador> lista = CriadorRepository.obterLista();

        model.addAttribute("listaCriadores", lista);
        model.addAttribute("mensagemInclusao", msg);
        return "/criador/lista";
    }

    @PostMapping(value = "/criador/incluir")
    public String incluir(Criador criador) {
        CriadorRepository.incluir(criador);
        msg = "Criador " + criador.getNomeCompleto() + " incluido com sucesso!";
        return "redirect:/criador/lista";
    }

    @GetMapping(value = "/criador/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        Criador criador = CriadorRepository.excluir(id);
        msg = "Criador " + criador.getNomeCompleto() + " excluído com sucesso!";
        return "redirect:/criador/lista";
    }
}
