package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Habilidade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHabilidadeRepository extends CrudRepository<Habilidade, Integer> {

    @Query("from Habilidade h where h.criador.id = :creatorId")
    public List<Habilidade> findAllByCreator(Integer creatorId);
}