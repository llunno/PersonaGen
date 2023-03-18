package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.service.CriadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class CriadorController {

    @Autowired
    private CriadorService criadorService;

    private static String msg;

    @GetMapping(value = "/criador/cadastro")
    public void exibirTelaCadastro() {}

    @GetMapping(value = "/criador/lista")
    public String exibirLista(Model model) {

        Collection<Criador> lista = criadorService.obterLista();

        model.addAttribute("listaCriadores", lista);
        model.addAttribute("mensagemInclusao", msg);
        return "/criador/lista";
    }

    @PostMapping(value = "/criador/incluir")
    public String incluir(Criador criador) {
        criadorService.incluir(criador);
        msg = "Criador " + criador.getNomeCompleto() + " incluido com sucesso!";
        return "redirect:/criador/lista";
    }

    @GetMapping(value = "/criador/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        Criador criador = criadorService.obterPorId(id);
        criadorService.excluir(id);
        msg = "Criador " + criador.getNomeCompleto() + " excluído com sucesso!";
        return "redirect:/criador/lista";
    }
}
