package br.edu.infnet.gerenciadorpersonagens.model.domain;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.UUID;

public class Personagem {
    private final UUID Id = UUID.randomUUID();
    private Criador criador;
    private ArrayList<Caracteristica> caracteristicas;
    private String nome;
    private boolean isHuman;
    private String genero;
    private String historia;

    @Override
    public String toString() {
        return Id + ";" + criador + ";" + caracteristicas + ";" + nome + ";" + isHuman + ";" + genero + ";" + historia;
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

    /*
    String.format(";%s",caracteristicas) +
     */
}
