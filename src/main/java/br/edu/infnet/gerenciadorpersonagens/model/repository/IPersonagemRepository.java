package br.edu.infnet.gerenciadorpersonagens.model.repository;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Personagem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IPersonagemRepository extends CrudRepository<Personagem, UUID> {
    @Query("from Personagem p where p.criador.id = :creatorId")
    List<Personagem> findAllByCreator(Integer creatorId);
}