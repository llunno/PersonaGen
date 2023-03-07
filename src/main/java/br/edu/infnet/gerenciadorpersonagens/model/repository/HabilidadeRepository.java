package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Habilidade;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HabilidadeRepository {
    private static Integer id = 1;
    private static final Map<Integer, Habilidade> mapaHabilidades = new HashMap<>();

    public static String incluir(Habilidade habilidade) {
        try {
            habilidade.setId(id++);
            mapaHabilidades.put(habilidade.getId(), habilidade);
            return null;
        } catch (Exception e) {
            return "Um problema foi detectado, por favor, tente novamente mais tarde! " + e.getMessage();
        }
    }

    public static Collection<Habilidade> obterLista() {
        return mapaHabilidades.values();
    }

    public static Habilidade excluir(Integer id) {
        return mapaHabilidades.remove(id);
    }
}
