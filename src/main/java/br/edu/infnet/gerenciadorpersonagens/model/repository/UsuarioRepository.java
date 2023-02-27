package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario;

import java.util.*;

public class UsuarioRepository {

    private static Integer id = 1;

    private static Map<Integer,Usuario> mapaUsuarios = new HashMap<>();

    public static boolean incluir(Usuario usuario) {
        try {
            usuario.setId(id++);
            mapaUsuarios.put(usuario.getId(), usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Collection<Usuario> obterLista() {
        return mapaUsuarios.values();
    }

    public static Usuario excluir(Integer key) {
        return mapaUsuarios.remove(key);
    }
}
