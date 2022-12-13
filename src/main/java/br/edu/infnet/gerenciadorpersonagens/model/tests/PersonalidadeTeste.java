package br.edu.infnet.gerenciadorpersonagens.model.tests;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Personalidade;
import br.edu.infnet.gerenciadorpersonagens.model.exceptions.ExpressaoInvalidaException;

import java.util.ArrayList;
import java.util.List;

public class PersonalidadeTeste {
    public static void main(String[] args) {
        Personalidade person1 = new Personalidade(
            "É um rapaz confiante e observador, com desejo de explorar o mundo e conhecer seus próprios" +
                    " limites",
            "Espírito aventureiro",
            "Han Solo",
            "Explorador",
            "Introvertido",
            "não definida",
            "agressivo",
            new ArrayList<>(List.of("Compassivo", "Caridoso", "Generoso", "Cordial", "Leal")),
            new ArrayList<>(List.of("Impaciente", "Vingativo", "Raivoso")),
            new ArrayList<>(List.of("Videogame", "Esportes", "Sair com os amigos")),
            new ArrayList<>(List.of("Carros", "Televisao", "Leitura", "Música"))
        );

        System.out.println(person1);
        System.out.println(person1.formatarExibicao());

        System.out.println();

        Personalidade person2 = new Personalidade(
                "Comunicativo e questionador, está sempre buscando levar suas ideias a frente",
                "Desenvoltura em debates",
                "Bill Clinton",
                "Questionador",
                "Maluco",
                "Cristã",
                "Combativo",
                new ArrayList<>(List.of("Honesto", "Sincero", "Defensor")),
                new ArrayList<>(List.of("Impaciente", "Agressivo", "Competitividade exacerbada")),
                new ArrayList<>(List.of("Videogame", "Esportes", "Ler jornais")),
                new ArrayList<>(List.of("Futebol", "Novela", "Redes sociais"))
        );

        System.out.println(person2);
        System.out.println(person2.formatarExibicao());
    }
}
