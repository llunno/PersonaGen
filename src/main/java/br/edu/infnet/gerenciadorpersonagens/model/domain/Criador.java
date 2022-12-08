package br.edu.infnet.gerenciadorpersonagens.model.domain;

import java.util.ArrayList;

public class Criador {
    private final String nomeCompleto;
    private final String nickname;
    private final int idade;
    private final ArrayList<String> interesses;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getNickname() {
        return nickname;
    }

    public int getIdade() {
        return idade;
    }

    public ArrayList<String> getInteresses() {
        return interesses;
    }

    public Criador(String nomeCompleto, String nickname, int idade, ArrayList<String> interesses) {
        this.nomeCompleto = nomeCompleto;
        this.nickname = nickname;
        this.idade = idade;
        this.interesses = interesses;
    }

    @Override
    public String toString() {
        StringBuilder dadosCriador = new StringBuilder();
        return String.valueOf(dadosCriador.append(nomeCompleto)
                .append(";").append(nickname)
                .append(";").append(idade)
                .append(";").append(interesses));
    }

}
