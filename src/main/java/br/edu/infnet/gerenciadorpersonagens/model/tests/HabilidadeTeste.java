package br.edu.infnet.gerenciadorpersonagens.model.tests;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Habilidade;

public class HabilidadeTeste {
    public static void main(String[] args) {
        Habilidade skill = new Habilidade(
                "Toca com maestria o violoncello",
                "Músicas clássicas",
                "Mozart",
                "Músico",
                "musical",
                "Domínio completo"
        );
        System.out.println(skill);
        System.out.println(skill.formatarExibicao());
    }
}
