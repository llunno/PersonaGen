package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EnderecoService {

    private final WebClient webClient = WebClient.create("https://viacep.com.br/ws/");

    public Endereco buscarEndereco(String cep) {
        return webClient.get()
                .uri(cep + "/json")
                .retrieve()
                .bodyToMono(Endereco.class)
                .block();
    }
}
