package br.edu.infnet.gerenciadorpersonagens.model.tests;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Habilidade;
import br.edu.infnet.gerenciadorpersonagens.model.exceptions.TipoHabilidadeInvalidoException;

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

        try {
            skill.setTipo("Aleatório");
        } catch (TipoHabilidadeInvalidoException e) {
            System.out.println("[ERRO]" + e.getMessage());
        }
    }
}
