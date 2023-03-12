package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Aparencia;
import br.edu.infnet.gerenciadorpersonagens.model.repository.AparenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AparenciaService {

    @Autowired
    private AparenciaRepository aparenciaRepository;

    public boolean incluir(Aparencia aparencia) {
        return aparenciaRepository.incluir(aparencia);
    }

    public Collection<Aparencia> obterLista() {
        return aparenciaRepository.obterLista();
    }

    public Aparencia excluir(Integer id) {
        return aparenciaRepository.excluir(id);
    }
}
