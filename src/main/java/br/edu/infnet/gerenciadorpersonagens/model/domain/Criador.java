package br.edu.infnet.gerenciadorpersonagens.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Criador  extends Usuario {
    private final int idade;
    private final ArrayList<String> interesses;


    public int getIdade() {
        return idade;
    }

    public ArrayList<String> getInteresses() {
        return interesses;
    }

    public Criador(String nomeCompleto, String nickname, String senha, String email, String idade, ArrayList<String> interesses) {
        super(email, senha, nomeCompleto, nickname);
        this.idade = Integer.parseInt(idade);
        if (interesses.size() == 1) {
            this.interesses = formatInteresses(interesses.get(0));
        }
        else {
            this.interesses = interesses;
        }
    }

    /*
    public Criador(String nomeCompleto, String nickname, String senhaCriador, String email, String idade, String interesses) {
        this.nomeCompleto = nomeCompleto;
        this.nickname = nickname;
        this.senhaCriador = senhaCriador;
        this.email = email;
        this.idade = Integer.parseInt(idade);
        this.interesses = formatInteresses(interesses);
    }

     */

    @Override
    public String toString() {
        StringBuilder dadosCriador = new StringBuilder();
        return super.toString() +
                dadosCriador.append(";").append(idade).append(";").append(interesses) + interesses.size();
    }

    public ArrayList<String> formatInteresses(String interesses) {
        String[] interessesClean = interesses.trim().split(",");
        return new ArrayList<>(List.of(interessesClean));
    }

}
