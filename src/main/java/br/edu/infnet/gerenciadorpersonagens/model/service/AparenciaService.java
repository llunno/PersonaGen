package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Aparencia;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Caracteristica;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Personagem;
import br.edu.infnet.gerenciadorpersonagens.model.repository.IAparenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        return aparenciaRepository.findAllSorted(Sort.by("biotipo"));
    }

    public void excluir(Integer id) {
        aparenciaRepository.deleteById(id);
    }

    public Aparencia obterPorId(Integer id) {
        return aparenciaRepository.findById(id).orElse(null);
    }

    public Collection<Aparencia> obterListaPorCriador(Integer creatorId) {
        return aparenciaRepository.findAllByCreator(creatorId, Sort.by("biotipo"));
    }

    public Aparencia obterAparenciaPorPersonagem(Personagem personagem) {

        Collection<Caracteristica> caracteristicas = personagem.getCaracteristicas();
        Aparencia aparencia;

        for (Caracteristica caracteristica : caracteristicas) {
            if (caracteristica instanceof Aparencia) {
                aparencia = (Aparencia) caracteristica;
                return aparencia;
            }
        }

        return null;
    }
}
