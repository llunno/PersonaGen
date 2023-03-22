package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdministradorRepository extends CrudRepository<Administrador, Integer>{
}
