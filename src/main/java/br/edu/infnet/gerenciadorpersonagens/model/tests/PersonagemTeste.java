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
                        new Personalidade(
                                "Amoroso e talentoso",
                                "Caridoso",
                                "Nelson Mandela",
                                "Pacífico",
                                "Extrovertido",
                                "Umbandista",
                                "Calmo",

                                new ArrayList<>(List.of(
                                        "Atencioso",
                                        "Luta por causas sociais",
                                        "Perseverante"
                                )),

                                new ArrayList<>(List.of(
                                        "Preguiçoso",
                                        "Da pouca atenção à familia",
                                        "Paranoico"
                                )),

                                new ArrayList<>(List.of(
                                        "Música MPB",
                                        "Política",
                                        "Criação de horta"
                                )),

                                new ArrayList<>(List.of(
                                        "Filmes de Terror",
                                        "esportes envolvendo luta",
                                        "bebidas alcóolicas"
                                ))
                        ),
                        new Aparencia(
                                "Bonito e contido",
                                "Olhos",
                                "Príncipe Harry",
                                1.70,
                                56,
                                "mesomorfo",
                                "branca",
                                "verde",
                                "ruivo",
                                "Cacheado"
                        ),
                        new Habilidade(
                                "Toca com maestria o violoncello",
                                "Músicas clássicas",
                                "Mozart",
                                "Músico",
                                "musical",
                                "Domínio completo"
                        )
                )
        ));
        p1.setNome("Wilson");
        p1.setIdade(25);
        p1.setHuman(true);
        p1.setGenero("Masculino");
        p1.setHistoria(
                "Antigo criador de porcos, veio do sertão com apenas 9 anos de idade para morar na cidade," +
                "conseguiu criar a vida por aqui e de forma árdua segue atingindo seus objetivos, se tornando músico" +
                " na orquestra local"
        );

        System.out.println(p1);
    }
}
