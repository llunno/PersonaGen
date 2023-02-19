package br.edu.infnet.gerenciadorpersonagens.model.domain;

public class Usuario {
    private String email;
    private String senha;
    private String nomeCompleto;
    private String nickname;

    public Usuario() {}

    public Usuario(String email, String senha, String nomeCompleto, String nickname) {
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

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getNickname() {
        return nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
