package br.edu.infnet.gerenciadorpersonagens.model.tests;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Caracteristica;

public class CaracteristicaTeste {
    public static void main(String[] args) {
        Caracteristica caract = new Caracteristica("Cara legal", "Caridoso", "Karl Marx") {

            @Override
            public String formatarExibicao() {
                return "Dados de personalidade: " + getDescricao() + "\nPonto de Destaque: " + getPontoDeDestaque() + "\nInspiração: " + getInspiracao();
            }
        };

        System.out.println(caract.formatarExibicao());
    }
}
