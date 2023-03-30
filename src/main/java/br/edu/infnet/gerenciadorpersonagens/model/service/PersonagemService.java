package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Personagem;
import br.edu.infnet.gerenciadorpersonagens.model.repository.IPersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class PersonagemService {
    private final IPersonagemRepository personagemRepository;

    public PersonagemService(IPersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    public Personagem incluir(Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    public Collection<Personagem> obterLista() {
        return (Collection<Personagem>) personagemRepository.findAll();
    }

    public void excluir(UUID id) {
        personagemRepository.deleteById(id);
    }

    public Personagem obterPorId(UUID id) {
        return personagemRepository.findById(id).orElse(null);
    }

    public Collection<Personagem> obterListaPorCriador(Integer creatorId) {
        return personagemRepository.findAllByCreator(creatorId);
    }

}