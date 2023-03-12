package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Habilidade;
import br.edu.infnet.gerenciadorpersonagens.model.repository.HabilidadeRepository;
import br.edu.infnet.gerenciadorpersonagens.model.service.HabilidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class HabilidadeController {

    @Autowired
    private HabilidadeService habilidadeService;

    private static String msg;

    @GetMapping(value = "/habilidade/cadastro")
    public void exibirTelaCadastro(){}

    @PostMapping(value = "/habilidade/incluir")
    public String incluir(Habilidade habilidade) {
        habilidadeService.incluir(habilidade);
        msg = "Habilidade " + habilidade.getNome() + " incluida com sucesso!";
        return "redirect:/habilidade/lista";
    }

    @GetMapping(value = "/habilidade/lista")
    public String exibirLista(Model model) {
        Collection<Habilidade> lista = habilidadeService.obterLista();

        model.addAttribute("listaHabilidades", lista);
        model.addAttribute("mensagemInclusao", msg);
        return "/habilidade/lista";
    }

    @GetMapping(value = "habilidade/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        Habilidade habilidade = habilidadeService.excluir(id);
        msg = "Habilidade " + habilidade.getNome() + " excluída com sucesso!";
        return "redirect:/habilidade/lista";
    }
}
