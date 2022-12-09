package br.edu.infnet.gerenciadorpersonagens.model.domain;

import br.edu.infnet.gerenciadorpersonagens.model.exceptions.TipoHabilidadeInvalidoException;

public class Habilidade extends Caracteristica {
    private String nome;
    private String tipo;
    private String maestria;

    public Habilidade(String descricao, String pontoDeDestaque, String inspiracao, String nome, String tipo, String maestria) {
        super(descricao, pontoDeDestaque, inspiracao);
        this.nome = nome;
        this.tipo = tipo;
        this.maestria = maestria;
    }

    @Override
    public String formatarExibicao() {
        StringBuilder stbuilder = new StringBuilder();
        return String.valueOf(stbuilder.append(nome).append(": ").append(getDescricao()));
    }

    public String toString() {
        return super.toString()
                + ";" + nome
                + ";" + tipo
                + ";" + maestria;
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

    public void setTipo(String tipo) throws TipoHabilidadeInvalidoException {
        if (!tipo.equalsIgnoreCase("física") &&
            !tipo.equalsIgnoreCase("fisica") &&
            !tipo.equalsIgnoreCase("intelectual") &&
            !tipo.equalsIgnoreCase("musical") &&
            !tipo.equalsIgnoreCase("emocional") &&
            !tipo.equalsIgnoreCase("intuitiva") &&
            !tipo.equalsIgnoreCase("Outro")) {
            throw new TipoHabilidadeInvalidoException(
                    "Tipo de habilidade informada inválida! Por favor, insira apenas as opções: " +
                            "Física, Intelectual, Musical, Emocional, Intuitiva ou Outro."
            );
        }
        else {
            this.tipo = tipo;
        }
    }

    public String getMaestria() {
        return maestria;
    }

    public void setMaestria(String maestria) {
        this.maestria = maestria;
    }
}
