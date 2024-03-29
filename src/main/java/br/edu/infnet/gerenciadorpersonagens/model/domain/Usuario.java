package br.edu.infnet.gerenciadorpersonagens.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String senha;
    private String nomeCompleto;
    private String nickname;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Log> logs;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Usuario() {}

    public Usuario(String email, String senha, String nomeCompleto, String nickname) {
        this();
        this.email = email;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.nickname = nickname;
    }

    public Usuario(String email, String senha) {
        this();
        this.email = email;
        this.senha = senha;
    }

    public String toString() {
        return email + ";" + nomeCompleto + ";" + nickname;
    }

}
