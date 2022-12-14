package br.edu.infnet.gerenciadorpersonagens.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

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

    public Criador getCriador() {
        return criador;
    }

    public void setCriador(Criador criador) {
        this.criador = criador;
    }

    public ArrayList<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(ArrayList<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
