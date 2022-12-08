package br.edu.infnet.gerenciadorpersonagens.model.domain;

public class Habilidade extends Caracteristica {
    private String nome;
    private String tipo;
    private String maestria;

    public Habilidade() {

    }

    public Habilidade(String nome, String tipo, String maestria) {
        super();
        this.nome = nome;
        this.tipo = tipo;
        this.maestria = maestria;
    }

    @Override
    public String formatDescricao() {
        StringBuilder stbuilder = new StringBuilder();
        return String.valueOf(stbuilder.append(nome).append(": ").append(getDescricao()));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMaestria() {
        return maestria;
    }

    public void setMaestria(String maestria) {
        this.maestria = maestria;
    }
}
