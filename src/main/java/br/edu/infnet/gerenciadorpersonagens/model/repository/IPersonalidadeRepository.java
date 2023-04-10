package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Personalidade;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonalidadeRepository extends CrudRepository<Personalidade, Integer> {
    @Query("from Personalidade p where p.criador.id = :creatorId")
    List<Personalidade> findAllByCreator(Integer creatorId, Sort sort);

    @Query("from Personalidade p")
    List<Personalidade> findAllSorted(Sort sort);
}
