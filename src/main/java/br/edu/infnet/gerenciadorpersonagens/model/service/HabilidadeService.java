package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Caracteristica;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Habilidade;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Personagem;
import br.edu.infnet.gerenciadorpersonagens.model.repository.IHabilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class HabilidadeService {

    @Autowired
    private CaracteristicaService caracteristicaService;

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
        return habilidadeRepository.findAllByCreator(creatorId, Sort.by("nome"));
    }

    public Collection<Habilidade> obterHabilidadesPorPersonagem(Personagem personagem) {

        Collection<Caracteristica> caracteristicas = personagem.getCaracteristicas();
        List<Habilidade> habilidades = new ArrayList<>();

        for (Caracteristica caracteristica : caracteristicas) {
            if (caracteristica instanceof Habilidade) {
                habilidades.add((Habilidade) caracteristica);
            }
        }
        return habilidades;
    }
}
