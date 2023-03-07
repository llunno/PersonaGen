package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Aparencia;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Habilidade;
import br.edu.infnet.gerenciadorpersonagens.model.repository.AparenciaRepository;
import br.edu.infnet.gerenciadorpersonagens.model.repository.HabilidadeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class AparenciaController {

    private static String msg;

    @GetMapping(value = "/aparencia/cadastro")
    public void exibirTelaCadastro(){}

    @PostMapping(value = "/aparencia/incluir")
    public String incluir(Aparencia aparencia) {
        AparenciaRepository.incluir(aparencia);
        msg = "Aparência " + aparencia.getId() + " incluida com sucesso!";
        return "redirect:/aparencia/lista";
    }

    @GetMapping(value = "/aparencia/lista")
    public String exibirLista(Model model) {
        Collection<Aparencia> lista = AparenciaRepository.obterLista();

        model.addAttribute("listaAparencia", lista);
        model.addAttribute("mensagemInclusao", msg);
        return "/aparencia/lista";
    }

    @GetMapping(value = "aparencia/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        Aparencia aparencia = AparenciaRepository.excluir(id);
        msg = "Aparência " + aparencia.getId() + " excluída com sucesso!";
        return "redirect:/aparencia/lista";
    }
}
