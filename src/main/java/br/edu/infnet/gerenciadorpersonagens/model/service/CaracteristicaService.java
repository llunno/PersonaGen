package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Caracteristica;
import br.edu.infnet.gerenciadorpersonagens.model.repository.ICaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CaracteristicaService {

    private final ICaracteristicaRepository caracteristicaRepository;

    @Autowired
    public CaracteristicaService(ICaracteristicaRepository caracteristicaRepository) {
        this.caracteristicaRepository = caracteristicaRepository;
    }

    public Caracteristica incluir(Caracteristica caracteristica) {
        return caracteristicaRepository.save(caracteristica);
    }

    public void excluir(Integer id) {
        caracteristicaRepository.deleteById(id);
    }

    public Collection<Caracteristica> obterLista() {
        return (Collection<Caracteristica>) caracteristicaRepository.findAll();
    }

    public Caracteristica obterPorId(Integer id) {
        return caracteristicaRepository.findById(id).orElse(null);
    }

    public Collection<Caracteristica> obterListaPorPersonagem(Integer personagemId) {
        return caracteristicaRepository.findAllByPersonagem(personagemId);
    }

    public Collection<Caracteristica> obterListaPorCriador(Integer creatorId) {
        return caracteristicaRepository.findAllByCreator(creatorId);
    }
}
