package br.edu.infnet.gerenciadorpersonagens.controller.REST;

import br.edu.infnet.gerenciadorpersonagens.model.service.EnderecoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(enderecoService.buscarEndereco(cep));
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
