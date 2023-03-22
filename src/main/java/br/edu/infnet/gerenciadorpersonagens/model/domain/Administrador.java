package br.edu.infnet.gerenciadorpersonagens.model.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity
public class Administrador extends Usuario {

    private String cargo;
    private String nivelAcesso;


    public Administrador() {}

    public Administrador(String email, String senha, String nomeCompleto, String nickname, String cargo, String nivelAcesso) {
        super(email, senha, nomeCompleto, nickname);
        this.cargo = cargo;
        this.nivelAcesso = nivelAcesso;
    }
}
