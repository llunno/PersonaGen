package br.edu.infnet.gerenciadorpersonagens.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

@Setter
@Getter
public class Personagem {
    private final UUID Id = UUID.randomUUID();
    private final LocalDateTime dataCriacao = LocalDateTime.now();
    private Criador criador;
    private ArrayList<Caracteristica> caracteristicas;
    private String nome;
    private int idade;
    private boolean isHuman;
    private String genero;
    private String historia;

    public String toString() {
        return String.format("%s",criador)
                + String.format(";Total de características registradas: %s",caracteristicas.size())
                + String.format(";%s",caracteristicas)
                + String.format(";%s",nome)
                + String.format(";%s",idade)
                + String.format(";%s",isHuman ? "Humano = Sim" : "Humano = Não")
                + String.format(";%s",genero)
                + String.format(";%s",historia)
                + String.format(";%s", formatarData());
    }

    private String formatarData() {
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

    public UUID getId() {
        return Id;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }

}
