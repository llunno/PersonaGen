package br.edu.infnet.gerenciadorpersonagens.model.domain;

import br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils;
import br.edu.infnet.gerenciadorpersonagens.model.exceptions.BiotipoInvalidoException;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Aparencia extends Caracteristica {
    private double altura;
    private double peso;
    private String biotipo;
    private String corPele;
    private String corOlhos;
    private String corCabelo;
    private String tipoCabelo;

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

    public void setBiotipo(String biotipo) throws BiotipoInvalidoException {
        if (!biotipo.equalsIgnoreCase(Utils.TIPO_FISICO[0]) &&
                !biotipo.equalsIgnoreCase(Utils.TIPO_FISICO[1]) &&
                !biotipo.equalsIgnoreCase(Utils.TIPO_FISICO[2])) {
            throw new BiotipoInvalidoException(
                    "Tipo físico informado inválido! Por favor, insira apenas as opções: Ectomorfo, Mesomorfo ou Endomorfo."
            );
        }
        else {
            this.biotipo = biotipo;
        }
    }

}
