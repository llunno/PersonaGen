package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Personalidade;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonalidadeRepository {

    private static Integer id = 1;
    private static final Map<Integer, Personalidade> mapaPersonalidades = new HashMap<>();

    public boolean incluir(Personalidade personalidade) {
        try {
            personalidade.setId(id++);
            mapaPersonalidades.put(personalidade.getId(), personalidade);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Collection<Personalidade> obterLista() {
        return mapaPersonalidades.values();
    }

    public Personalidade excluir(Integer id) {
        return mapaPersonalidades.remove(id);
    }
}
