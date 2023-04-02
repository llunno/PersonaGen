package br.edu.infnet.gerenciadorpersonagens.controller.REST;

import br.edu.infnet.gerenciadorpersonagens.model.service.EnderecoService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/endereco")
public class APIEndereco {

    private final EnderecoService enderecoService;

    @Autowired
    public APIEndereco(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping(value = "/{cep}")
    public String buscarEndereco(@PathVariable String cep) {
        Gson gson = new Gson();
        return gson.toJson(enderecoService.buscarEndereco(cep));
    }
}
