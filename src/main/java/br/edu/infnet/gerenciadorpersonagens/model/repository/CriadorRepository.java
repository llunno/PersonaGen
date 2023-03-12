package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CriadorRepository {

    private static Integer id = 1;
    private static final Map<Integer, Criador> mapaCriadores = new HashMap<>();

    public boolean incluir(Criador criador) {
        try {
            criador.setId(id++);
            mapaCriadores.put(criador.getId(), criador);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Collection<Criador> obterLista() {
        return mapaCriadores.values();
    }

    public Criador excluir(Integer id) {
        return mapaCriadores.remove(id);
    }
}
