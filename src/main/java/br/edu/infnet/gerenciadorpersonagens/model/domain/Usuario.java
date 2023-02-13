package br.edu.infnet.gerenciadorpersonagens.model.domain;

public class Usuario {
    private final String email;
    private final String senha;
    private final String nomeCompleto;
    private final String nickname;

    protected Usuario(String email, String senha, String nomeCompleto, String nickname) {
        this.email = email;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.nickname = nickname;
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
}
