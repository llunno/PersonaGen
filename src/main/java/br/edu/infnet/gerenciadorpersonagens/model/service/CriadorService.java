package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.repository.ICriadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CriadorService {

    @Autowired
    private ICriadorRepository criadorRepository;

    public Criador incluir(Criador criador) {
        return criadorRepository.save(criador);
    }

    public Collection<Criador> obterLista() {
        return (Collection<Criador>) criadorRepository.findAll();
    }

    public Collection<Criador> obterListaOrdenada() {
        return criadorRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeCompleto"));
    }

    public void excluir(Integer id) {
        criadorRepository.deleteById(id);
    }

    public Criador obterPorId(Integer id) {
        return criadorRepository.findById(id).orElse(null);
    }
}
