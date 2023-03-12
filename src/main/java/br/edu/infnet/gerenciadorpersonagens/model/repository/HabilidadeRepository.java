package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Habilidade;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class HabilidadeRepository {
    private static Integer id = 1;
    private static final Map<Integer, Habilidade> mapaHabilidades = new HashMap<>();

    public boolean incluir(Habilidade habilidade) {
        try {
            habilidade.setId(id++);
            mapaHabilidades.put(habilidade.getId(), habilidade);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Collection<Habilidade> obterLista() {
        return mapaHabilidades.values();
    }

    public Habilidade excluir(Integer id) {
        return mapaHabilidades.remove(id);
    }
}
