package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Habilidade;
import br.edu.infnet.gerenciadorpersonagens.model.repository.IHabilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HabilidadeService {

    @Autowired
    private IHabilidadeRepository habilidadeRepository;

    public Habilidade incluir(Habilidade habilidade) {
        return habilidadeRepository.save(habilidade);
    }

    public Collection<Habilidade> obterLista() {
        return (Collection<Habilidade>) habilidadeRepository.findAll();
    }

    public void excluir(Integer id) {
         habilidadeRepository.deleteById(id);
    }

    public Habilidade obterPorId(Integer id) {
        return habilidadeRepository.findById(id).orElse(null);
    }

    public Collection<Habilidade> obterListaPorCriador(Integer creatorId) {
        return habilidadeRepository.findAllByCreator(creatorId);
    }
}
