package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Aparencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAparenciaRepository extends CrudRepository<Aparencia, Integer> {
    @Query("from Aparencia a where a.criador.id = :creatorId")
    public List<Aparencia> findAllByCreator(Integer creatorId);
}
