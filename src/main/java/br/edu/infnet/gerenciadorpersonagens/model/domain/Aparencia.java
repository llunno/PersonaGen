package br.edu.infnet.gerenciadorpersonagens.model.domain;

import br.edu.infnet.gerenciadorpersonagens.model.exceptions.BiotipoInvalidoException;
import br.edu.infnet.gerenciadorpersonagens.model.exceptions.TipoHabilidadeInvalidoException;

public class Aparencia extends Caracteristica {
    private double altura = 1.70;
    private double peso = 75;
    private String biotipo = "mesomorfo";
    private String corPele = "parda";
    private String corOlhos = "castanhos";
    private String corCabelo = "preto";
    private String tipoCabelo = "liso";

    public Aparencia(
            String descricao,
            String pontoDeDestaque,
            String inspiracao,
            double altura,
            double peso,
            String biotipo,
            String corPele,
            String corOlhos,
            String corCabelo,
            String tipoCabelo
    ) {
        super(descricao,pontoDeDestaque,inspiracao);
        this.altura = altura;
        this.peso = peso;
        this.biotipo = biotipo;
        this.corPele = corPele;
        this.corOlhos = corOlhos;
        this.corCabelo = corCabelo;
        this.tipoCabelo = tipoCabelo;
    }

    //TODO: A implementar metodo abstrato
    @Override
    public String formatarExibicao() {
        StringBuilder stbuilder = new StringBuilder();
        return String.valueOf(stbuilder.append("Altura: ")
                .append(altura).append("\n")
                .append("Peso: ").append(peso).append("\n")
                .append("Biotipo: ").append(biotipo).append("\n")
                .append("Descrição: ").append(getDescricao()));
    }

    @Override
    public String toString() {
        return super.toString()
                + ";" + altura
                + ";" + peso
                + ";" + biotipo
                + ";" + corPele
                + ";" + corOlhos
                + ";" + corCabelo
                + ";" + tipoCabelo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getBiotipo() {
        return biotipo;
    }

    public void setBiotipo(String biotipo) throws BiotipoInvalidoException {
        if (!biotipo.equalsIgnoreCase("mesomorfo") &&
                !biotipo.equalsIgnoreCase("endomorfo") &&
                !biotipo.equalsIgnoreCase("ectomorfo")) {
            throw new BiotipoInvalidoException(
                    "Tipo físico informado inválido! Por favor, insira apenas as opções: Ectomorfo, Mesomorfo ou Endomorfo."
            );
        }
        else {
            this.biotipo = biotipo;
        }
    }

    public String getCorPele() {
        return corPele;
    }

    public void setCorPele(String corPele) {
        this.corPele = corPele;
    }

    public String getCorOlhos() {
        return corOlhos;
    }

    public void setCorOlhos(String corOlhos) {
        this.corOlhos = corOlhos;
    }

    public String getCorCabelo() {
        return corCabelo;
    }

    public void setCorCabelo(String corCabelo) {
        this.corCabelo = corCabelo;
    }

    public String getTipoCabelo() {
        return tipoCabelo;
    }

    public void setTipoCabelo(String tipoCabelo) {
        this.tipoCabelo = tipoCabelo;
    }
}
