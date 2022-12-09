package br.edu.infnet.gerenciadorpersonagens.model.domain;

public abstract class Caracteristica {
    private final String descricao;
    private final String pontoDeDestaque;
    private final String inspiracao;

    //private String beneficio;

    //private String maleficio

    public Caracteristica(String descricao, String pontoDeDestaque, String inspiracao) {
        this.descricao = descricao;
        this.pontoDeDestaque = pontoDeDestaque;
        this.inspiracao = inspiracao;
    }

    public abstract String formatarExibicao();

    @Override
    public String toString() {
        StringBuilder caracteristicas = new StringBuilder();
        return String.valueOf(caracteristicas.append(descricao)
                .append(";").append(pontoDeDestaque)
                .append(";").append(inspiracao));
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPontoDeDestaque() {
        return pontoDeDestaque;
    }

    public String getInspiracao() {
        return inspiracao;
    }
}
