package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario;

public class AcessoRepository {
    public static Usuario autenticar(Usuario usuario) {
        if (usuario.getEmail().equalsIgnoreCase(usuario.getSenha())) {
            return new Usuario(usuario.getEmail(), usuario.getSenha(), "Administrador", "Adm021");
        }
        return null;
    }
}
