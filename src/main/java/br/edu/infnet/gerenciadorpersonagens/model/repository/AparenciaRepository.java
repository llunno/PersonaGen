package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Aparencia;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AparenciaRepository {
    private static Integer id = 1;
    private static final Map<Integer, Aparencia> mapaAparencias = new HashMap<>();

    public boolean incluir(Aparencia aparencia) {
        try {
            aparencia.setId(id++);
            mapaAparencias.put(aparencia.getId(), aparencia);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Collection<Aparencia> obterLista() {
        return mapaAparencias.values();
    }

    public Aparencia excluir(Integer id) {
        return mapaAparencias.remove(id);
    }
}
