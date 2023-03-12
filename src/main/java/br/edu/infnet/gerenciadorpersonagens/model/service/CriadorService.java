package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.repository.CriadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CriadorService {

    @Autowired
    private CriadorRepository criadorRepository;

    public boolean incluir(Criador criador) {
        return criadorRepository.incluir(criador);
    }

    public Collection<Criador> obterLista() {
        return criadorRepository.obterLista();
    }

    public Criador excluir(Integer id) {
        return  criadorRepository.excluir(id);
    }
}
