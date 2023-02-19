package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private static List<Usuario> lista = new ArrayList<Usuario>();

    public static boolean incluir(Usuario usuario) {
        try {
            lista.add(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<Usuario> obterLista() {
        return lista;
    }
}
