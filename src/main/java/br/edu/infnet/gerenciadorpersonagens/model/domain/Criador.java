package br.edu.infnet.gerenciadorpersonagens.model.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Criador  extends Usuario {

    private int idade;
    @ElementCollection
    private List<String> interesses;
    public Criador() {}

    public Criador(String nomeCompleto, String nickname, String senha, String email, String idade, List<String> interesses) {
        super(email, senha, nomeCompleto, nickname);
        this.idade = Integer.parseInt(idade);
        this.interesses = interesses;
    }

    @Override
    public String toString() {
        StringBuilder dadosCriador = new StringBuilder();
        return super.toString() +
                dadosCriador.append(";").append(idade).append(";").append(interesses) + interesses.size();
    }

}
