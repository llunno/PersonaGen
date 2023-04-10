package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Endereco;
import br.edu.infnet.gerenciadorpersonagens.model.repository.IEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collection;

@Service
public class EnderecoService {

    private final WebClient webClient = WebClient.create("https://viacep.com.br/ws/");
    private final IEnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(IEnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco buscarEndereco(String cep) {
        return webClient.get()
                .uri(cep + "/json")
                .retrieve()
                .bodyToMono(Endereco.class)
                .block();
    }

    public void incluir(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public void excluir(Integer id) {
        enderecoRepository.deleteById(id);
    }

    public void alterar(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public Endereco obterPorId(Integer id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public Collection<Endereco> obterLista() {
        return (Collection<Endereco>) enderecoRepository.findAll();
    }
}
