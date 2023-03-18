package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository  extends CrudRepository<Usuario, Integer> {
    @Query("from Usuario u where u.email = :email and u.senha = :senha")
    Usuario autenticar(String email, String senha);
}
