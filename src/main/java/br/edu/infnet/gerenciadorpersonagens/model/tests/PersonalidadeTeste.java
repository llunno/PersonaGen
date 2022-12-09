package br.edu.infnet.gerenciadorpersonagens.model.tests;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Personalidade;

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
            new ArrayList<>(List.of("Compasivo", "Caridoso", "Generoso", "Cordial", "Leal")),
            new ArrayList<>(List.of("Impaciente", "Vingativo", "Raivoso")),
            new ArrayList<>(List.of("Videogame", "Esportes", "Sair com os amigos")),
            new ArrayList<>(List.of("Carros", "Televisao", "Leitura", "Música"))
        );

        System.out.println(person1);
        System.out.println(person1.formatarExibicao());
    }
}
