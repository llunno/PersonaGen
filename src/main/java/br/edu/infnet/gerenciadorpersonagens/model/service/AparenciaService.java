package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Aparencia;
import br.edu.infnet.gerenciadorpersonagens.model.repository.IAparenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AparenciaService {

    @Autowired
    private IAparenciaRepository aparenciaRepository;

    public Aparencia incluir(Aparencia aparencia) {
        return aparenciaRepository.save(aparencia);
    }

    public Collection<Aparencia> obterLista() {
        return (Collection<Aparencia>) aparenciaRepository.findAll();
    }

    public void excluir(Integer id) {
        aparenciaRepository.deleteById(id);
    }

    public Aparencia obterPorId(Integer id) {
        return aparenciaRepository.findById(id).orElse(null);
    }

    public Collection<Aparencia> obterListaPorCriador(Integer creatorId) {
        return aparenciaRepository.findAllByCreator(creatorId);
    }
}
