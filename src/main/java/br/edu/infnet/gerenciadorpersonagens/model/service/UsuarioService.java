package br.edu.infnet.gerenciadorpersonagens.model.service;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario;
import br.edu.infnet.gerenciadorpersonagens.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean incluir(Usuario usuario) {
        return usuarioRepository.incluir(usuario);
    }

    public Usuario excluir(Integer id) {
        return usuarioRepository.excluir(id);
    }

    public Collection<Usuario> obterLista() {
        return usuarioRepository.obterLista();
    }
}
