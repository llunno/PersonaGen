package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CriadorRepository {

    private static Integer id = 1;
    private static final Map<Integer, Criador> mapaCriadores = new HashMap<>();

    public static String incluir(Criador criador) {
        try {
            criador.setId(id++);
            mapaCriadores.put(criador.getId(), criador);
            return null;
        } catch (Exception e) {
            return "Um problema foi detectado, por favor, tente novamente mais tarde! " + e.getMessage();
        }
    }

    public static Collection<Criador> obterLista() {
        return mapaCriadores.values();
    }

    public static Criador excluir(Integer id) {
        return mapaCriadores.remove(id);
    }
}
