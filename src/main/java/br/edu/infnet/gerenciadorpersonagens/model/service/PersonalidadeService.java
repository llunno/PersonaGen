package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Caracteristica;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Personagem;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Personalidade;
import br.edu.infnet.gerenciadorpersonagens.model.repository.IPersonalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonalidadeService {

    @Autowired
    private IPersonalidadeRepository personalidadeRepository;

    public Personalidade incluir(Personalidade personalidade) {
        return personalidadeRepository.save(personalidade);
    }

    public Collection<Personalidade> obterLista() {
        return personalidadeRepository.findAllSorted(Sort.by("tipoExpressao"));
    }

    public void excluir(Integer id) {
        personalidadeRepository.deleteById(id);
    }

    public Personalidade obterPorId(Integer id) {
        return personalidadeRepository.findById(id).orElse(null);
    }

    public Collection<Personalidade> obterListaPorCriador(Integer creatorId) {
        return personalidadeRepository.findAllByCreator(creatorId, Sort.by("tipoExpressao"));
    }

    public Personalidade obterPersonalidadePorPersonagem(Personagem personagem) {

        Collection<Caracteristica> caracteristicas = personagem.getCaracteristicas();
        Personalidade personalidade;

        for (Caracteristica caracteristica : caracteristicas) {
            if (caracteristica instanceof Personalidade) {
                personalidade = (Personalidade) caracteristica;
                return personalidade;
            }
        }

        return null;
    }
}
