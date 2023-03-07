package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Aparencia;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AparenciaRepository {
    private static Integer id = 1;
    private static final Map<Integer, Aparencia> mapaAparencias = new HashMap<>();

    public static String incluir(Aparencia aparencia) {
        try {
            aparencia.setId(id++);
            mapaAparencias.put(aparencia.getId(), aparencia);
            return null;
        } catch (Exception e) {
            return "Um problema foi detectado, por favor, tente novamente mais tarde! " + e.getMessage();
        }
    }

    public static Collection<Aparencia> obterLista() {
        return mapaAparencias.values();
    }

    public static Aparencia excluir(Integer id) {
        return mapaAparencias.remove(id);
    }
}
