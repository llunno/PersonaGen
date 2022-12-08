package br.edu.infnet.gerenciadorpersonagens.model.tests;

import br.edu.infnet.gerenciadorpersonagens.model.domain.*;

import java.util.ArrayList;
import java.util.List;

public class PersonagemTeste {
    public static void main(String[] args) {
        Personagem p1 = new Personagem();

        p1.setCriador(new Criador(
                "Carlos Alberto",
                "crlerto23",
                32,
                new ArrayList<>(
                        List.of("Fantasia", "Romance", "Cinema", "Personas", "Quadrinhos")
                )
        ));
        p1.setCaracteristicas(new ArrayList<>(
                List.of(
                        new Aparencia(),
                        new Habilidade("Músico", "musical", "Domínio completo")
                )
        ));
        p1.setNome("Wilson");
        p1.setHuman(true);
        p1.setHistoria(
                "Antigo criador de porcos, veio do sertão com apenas 9 anos de idade para morar na cidade," +
                "conseguiu criar a vida por aqui e de forma árdua segue atingindo seus objetivos, se tornando músico" +
                "na orquestra local"
        );

        System.out.println(p1);
    }
}
