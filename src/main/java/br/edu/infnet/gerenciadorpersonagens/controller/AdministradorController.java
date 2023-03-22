package br.edu.infnet.gerenciadorpersonagens.controller;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Administrador;
import br.edu.infnet.gerenciadorpersonagens.model.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class AdministradorController {

    @Autowired
    AdministradorService administradorService;

    private static String msg;

    @GetMapping(value = "/administrador/cadastro")
    public void exibirTelaCadastro(){}

    @PostMapping(value = "/administrador/incluir")
    public String incluir(Administrador administrador) {
        msg = "Administrador " + administrador.getNomeCompleto() + " incluido com sucesso!";
        administradorService.incluir(administrador);
        return "redirect:/administrador/lista";
    }

    @GetMapping(value = "/administrador/lista")
    public String exibirLista(Model model) {
        Collection<Administrador> lista = administradorService.obterLista();

        model.addAttribute("listaAdministrador", lista);
        model.addAttribute("mensagemInclusao", msg);
        return "/administrador/lista";
    }

    @GetMapping(value = "administrador/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        administradorService.excluir(id);
        msg = "Administrador " + id + " excluída com sucesso!";
        return "redirect:/administrador/lista";
    }
}
