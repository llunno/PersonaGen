package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IAcessoRepository extends CrudRepository<Usuario, Integer> {
}
