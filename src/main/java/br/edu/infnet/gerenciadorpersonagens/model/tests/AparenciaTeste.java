package br.edu.infnet.gerenciadorpersonagens.model.tests;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Aparencia;
import br.edu.infnet.gerenciadorpersonagens.model.exceptions.BiotipoInvalidoException;

public class AparenciaTeste {
    public static void main(String[] args) {
        Aparencia aparencia = new Aparencia(
                "Rosto de forma arredondada, com barba a fazer e nariz levemente avantajado",
                "Olhos",
                "Príncipe Harry",
                1.70,
                56,
                "mesomorfo",
                "branca",
                "verde",
                "ruivo",
                "Cacheado"
        );
        try {
            aparencia.setBiotipo("Gordo");
        } catch (BiotipoInvalidoException e) {
            System.out.println("Biotipo informado é inválido");
        }
        System.out.println(aparencia);
        System.out.println();
        System.out.println(aparencia.formatarExibicao());


    }
}
