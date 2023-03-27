package br.edu.infnet.gerenciadorpersonagens.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private String pontoDeDestaque;
    private String inspiracao;
    
    @ManyToOne
    @JoinColumn(name = "criador_id")
    private Criador criador;

    @ManyToMany(mappedBy = "caracteristicas")
    private List<Personagem> personagensAssociados;

    public Caracteristica(String descricao, String pontoDeDestaque, String inspiracao) {
        this.descricao = descricao;
        this.pontoDeDestaque = pontoDeDestaque;
        this.inspiracao = inspiracao;
    }

    protected Caracteristica() {
    }

    public abstract String formatarExibicao();

    @Override
    public String toString() {
        StringBuilder caracteristicas = new StringBuilder();
        return String.valueOf(caracteristicas.append(descricao)
                .append(";").append(pontoDeDestaque)
                .append(";").append(inspiracao));
    }

}
