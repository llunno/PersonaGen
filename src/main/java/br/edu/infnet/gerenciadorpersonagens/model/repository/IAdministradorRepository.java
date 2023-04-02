package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Administrador;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdministradorRepository extends CrudRepository<Administrador, Integer>{

    @Query("from Administrador a")
    public List<Administrador> findAll(Sort sort);
}
