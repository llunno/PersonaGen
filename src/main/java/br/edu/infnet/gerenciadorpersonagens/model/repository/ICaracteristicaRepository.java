package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Caracteristica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ICaracteristicaRepository extends CrudRepository<Caracteristica, Integer> {

    @Query("from Caracteristica c where c.criador.id = :creatorId")
    Collection<Caracteristica> findAllByCreator(Integer creatorId);


    @Query("select c from Caracteristica c inner join c.personagens p where p.id = :personagemId")
    Collection<Caracteristica> findAllByPersonagem(Integer personagemId);
}