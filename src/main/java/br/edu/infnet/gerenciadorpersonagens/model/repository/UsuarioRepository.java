package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UsuarioRepository {

    private static Integer id = 1;

    private static final Map<Integer,Usuario> mapaUsuarios = new HashMap<>();

    public boolean incluir(Usuario usuario) {
        try {
            usuario.setId(id++);
            mapaUsuarios.put(usuario.getId(), usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Collection<Usuario> obterLista() {
        return mapaUsuarios.values();
    }

    public Usuario excluir(Integer key) {
        return mapaUsuarios.remove(key);
    }
}
