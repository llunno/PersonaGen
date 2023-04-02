package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Caracteristica;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Habilidade;
import br.edu.infnet.gerenciadorpersonagens.model.repository.IHabilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

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
        return habilidadeRepository.findAllByCreator(creatorId);
    }

    public Collection<Habilidade> obterListaPorPersonagem(Integer personagemId) {

        Collection<Caracteristica> caracteristicasPersonagem = caracteristicaService.obterListaPorPersonagem(personagemId);

        Collection<Habilidade> habilidadesPersonagem = new ArrayList<>();

        for (Caracteristica caracteristica : caracteristicasPersonagem) {
            if (caracteristica instanceof Habilidade) {
                habilidadesPersonagem.add((Habilidade) caracteristica);
            }
        }

        return habilidadesPersonagem;
    }
}
