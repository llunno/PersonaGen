package br.edu.infnet.gerenciadorpersonagens.model.tests;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Caracteristica;

public class CaracteristicaTeste {
    public static void main(String[] args) {
        Caracteristica caract = new Caracteristica("Cara legal", "perceptível", "Karl Marx") {

            @Override
            public String formatDescricao() {
                return "Dados de personalidade: " + getDescricao() + "\nIntensidade: " + getIntensidade() + "\nInspiração: " + getInspiracao();
            }
        };

        System.out.println(caract.formatDescricao());
    }
}
