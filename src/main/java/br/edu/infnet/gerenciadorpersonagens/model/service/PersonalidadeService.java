package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Personalidade;
import br.edu.infnet.gerenciadorpersonagens.model.repository.IPersonalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonalidadeService {

    @Autowired
    private IPersonalidadeRepository personalidadeRepository;

    public Personalidade incluir(Personalidade personalidade) {
        return personalidadeRepository.save(personalidade);
    }

    public Collection<Personalidade> obterLista() {
        return (Collection<Personalidade>) personalidadeRepository.findAll();
    }

    public void excluir(Integer id) {
        personalidadeRepository.deleteById(id);
    }

    public Personalidade obterPorId(Integer id) {
        return personalidadeRepository.findById(id).orElse(null);
    }
}
