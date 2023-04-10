package br.edu.infnet.gerenciadorpersonagens.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Setter
@Getter
@Entity
public class Personagem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private final LocalDateTime dataCriacao = LocalDateTime.now();
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "criador_id")
    private Criador criador;
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Caracteristica> caracteristicas;
    private String nome;
    private int idade;
    private boolean isHuman;
    private String especie;
    private String genero;
    private String historia;

    public Personagem() {}

    public Personagem(String nome, int idade, boolean isHuman, String especie, String genero, String historia) {
        this.nome = nome;
        this.idade = idade;
        this.isHuman = isHuman;
        this.especie = especie;
        this.genero = genero;
        this.historia = historia;
    }

    public String toString() {
        return String.format("%s",criador)
                + String.format(";Total de características registradas: %s",caracteristicas.size())
                + String.format(";%s",caracteristicas)
                + String.format(";%s",nome)
                + String.format(";%s",idade)
                + String.format(";%s",isHuman ? "Humano = Sim" : "Humano = Não")
                + String.format(";%s",especie)
                + String.format(";%s",genero)
                + String.format(";%s",historia)
                + String.format(";%s", formatarData());
    }

    public String formatarData() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return this.dataCriacao.format(formato);
    }

    public String gerarLinhaGravacao() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.formatarData());
        sb.append(";");
        sb.append(this.getNome());
        sb.append(";");
        sb.append(this.getCriador().getNickname());
        sb.append(";");
        sb.append(this.getCaracteristicas().size());
        sb.append("\r\n");
        return sb.toString();
    }

    public String formatIsHuman() {
        if (this.isHuman) {
            return "Sim";
        }
        else {
            return "Não";
        }
    }

    public void setIsHuman(boolean isHuman) {
        if (isHuman) {
            this.especie = "Humano";
        }
        this.isHuman = isHuman;
    }
}
