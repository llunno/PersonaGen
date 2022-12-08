package br.edu.infnet.gerenciadorpersonagens.model.tests;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;

import java.util.ArrayList;
import java.util.Arrays;

public class CriadorTeste {
    public static void main(String[] args) {
        Criador criador1 = new Criador (
                "Carlos Alberto Santos",
                "carlosAlbos",
                45,
                new ArrayList<>(
                        Arrays.asList("Novelas", "Ficção", "Arte")
                )
        );

        Criador criador2 = new Criador (
                "Roberto Manoel Gomes",
                "RobertoGomes",
                31,
                new ArrayList<>(
                        Arrays.asList("Terror", "Suspense", "Histórias policiais", "Jogos RPG")
                )
        );

        System.out.println(criador1);
        System.out.println(criador2);
    }
}
