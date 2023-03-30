package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Log;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILogRepository extends CrudRepository<Log, Integer> {

    @Query("from Log l where l.usuario.id = :userId")
    List<Log> findAllByUser(Integer userId);
}
