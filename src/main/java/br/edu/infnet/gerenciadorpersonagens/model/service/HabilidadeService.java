package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Habilidade;
import br.edu.infnet.gerenciadorpersonagens.model.repository.HabilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HabilidadeService {

    @Autowired
    private HabilidadeRepository habilidadeRepository;

    public boolean incluir(Habilidade habilidade) {
        return habilidadeRepository.incluir(habilidade);
    }

    public Collection<Habilidade> obterLista() {
        return habilidadeRepository.obterLista();
    }

    public Habilidade excluir(Integer id) {
        return habilidadeRepository.excluir(id);
    }
}
