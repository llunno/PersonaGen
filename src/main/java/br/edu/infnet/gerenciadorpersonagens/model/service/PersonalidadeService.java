package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Personalidade;
import br.edu.infnet.gerenciadorpersonagens.model.repository.PersonalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonalidadeService {

    @Autowired
    private PersonalidadeRepository personalidadeRepository;

    public boolean incluir(Personalidade personalidade) {
        return personalidadeRepository.incluir(personalidade);
    }

    public Collection<Personalidade> obterLista() {
        return personalidadeRepository.obterLista();
    }

    public Personalidade excluir(Integer id) {
        return personalidadeRepository.excluir(id);
    }
}
