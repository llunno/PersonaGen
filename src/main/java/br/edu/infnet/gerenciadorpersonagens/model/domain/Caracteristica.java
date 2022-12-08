package br.edu.infnet.gerenciadorpersonagens.model.domain;

public abstract class Caracteristica {
    private String descricao;
    private String intensidade;
    private String inspiracao;


    public Caracteristica() {}

    public Caracteristica(String descricao, String intensidade, String inspiracao) {
        this.descricao = descricao;
        this.intensidade = intensidade;
        this.inspiracao = inspiracao;
    }

    public abstract String formatDescricao();

    @Override
    public String toString() {
        StringBuilder caracteristicas = new StringBuilder();
        return String.valueOf(caracteristicas.append(descricao)
                .append(";").append(intensidade)
                .append(";").append(inspiracao));
    }

    public String getDescricao() {
        return descricao;
    }

    public String getIntensidade() {
        return intensidade;
    }

    public String getInspiracao() {
        return inspiracao;
    }
}
