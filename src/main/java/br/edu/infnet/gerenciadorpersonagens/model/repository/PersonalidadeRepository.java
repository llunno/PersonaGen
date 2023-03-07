package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Personalidade;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PersonalidadeRepository {

    private static Integer id = 1;
    private static final Map<Integer, Personalidade> mapaPersonalidades = new HashMap<>();

    public static String incluir(Personalidade personalidade) {
        try {
            personalidade.setId(id++);
            mapaPersonalidades.put(personalidade.getId(), personalidade);
            return null;
        } catch (Exception e) {
            return "Um problema foi detectado, por favor, tente novamente mais tarde! " + e.getMessage();
        }
    }

    public static Collection<Personalidade> obterLista() {
        return mapaPersonalidades.values();
    }

    public static Personalidade excluir(Integer id) {
        return mapaPersonalidades.remove(id);
    }
}
