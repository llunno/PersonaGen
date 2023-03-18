package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Personalidade;
import br.edu.infnet.gerenciadorpersonagens.model.service.PersonalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class PersonalidadeController {

    @Autowired
    private PersonalidadeService personalidadeService;

    private static String msg;

    @GetMapping(value = "/personalidade/cadastro")
    public void exibirTelaCadastro(){}

    @PostMapping(value = "/personalidade/incluir")
    public String incluir(Personalidade personalidade) {
        Personalidade personalidadeIncluida = personalidadeService.incluir(personalidade);
        msg = "Personalidade " + personalidadeIncluida.getId() + " incluida com sucesso!";
        return "redirect:/personalidade/lista";
    }

    @GetMapping(value = "/personalidade/lista")
    public String exibirLista(Model model) {
        Collection<Personalidade> lista = personalidadeService.obterLista();

        model.addAttribute("listaPersonalidade", lista);
        model.addAttribute("mensagemInclusao", msg);
        return "/personalidade/lista";
    }

    @GetMapping(value = "personalidade/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        Personalidade personalidade = personalidadeService.obterPorId(id);
        personalidadeService.excluir(id);
        msg = "Personalidade " + personalidade.getId() + " excluída com sucesso!";
        return "redirect:/personalidade/lista";
    }

}
