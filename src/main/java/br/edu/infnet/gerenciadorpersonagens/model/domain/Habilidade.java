package br.edu.infnet.gerenciadorpersonagens.model.domain;

import br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils;
import br.edu.infnet.gerenciadorpersonagens.model.exceptions.TipoHabilidadeInvalidoException;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Habilidade extends Caracteristica {
    private String nome;
    private String tipo;
    private String maestria;

    public Habilidade() {}

    public Habilidade(String descricao, String pontoDeDestaque, String inspiracao, Criador criador, String nome, String tipo, String maestria) {
        super(descricao, pontoDeDestaque, inspiracao);
        super.setCriador(criador);
        this.nome = nome;
        this.tipo = tipo;
        this.maestria = maestria;
    }

    public Habilidade(String descricao, String pontoDeDestaque, String inspiracao, String nome, String tipo, String maestria) {
        super(descricao, pontoDeDestaque, inspiracao);
        this.nome = nome;
        this.tipo = tipo;
        this.maestria = maestria;
    }

    @Override
    public String formatarExibicao() {
        StringBuilder stbuilder = new StringBuilder();
        return String.valueOf(stbuilder.append(nome).append(": ").append(getDescricao()));
    }

    public String toString() {
        return super.toString()
                + ";" + nome
                + ";" + tipo
                + ";" + maestria;
    }

    public String formatTelaCadastroPersonagem() {

        return "<strong>Nome</strong>: " + nome + ".<br>"
                + "<strong>Tipo</strong>: " + tipo + ".<br>"
                + "<strong>Maestria</strong>: " + maestria + ".<br>"
                + "<strong>Descrição</strong>: " + getDescricao() + ".<br>"
                + "<strong>Ponto de Destaque</strong>: " + getPontoDeDestaque() + ".<br>"
                + "<strong>Inspiração</strong>: " + getInspiracao() + ".<br>";
    }

    public void setTipo(String tipo) throws TipoHabilidadeInvalidoException {
        if (!tipo.equalsIgnoreCase(Utils.TIPO_HABILIDADE[0]) &&
                !tipo.equalsIgnoreCase(Utils.TIPO_HABILIDADE[1]) &&
                !tipo.equalsIgnoreCase(Utils.TIPO_HABILIDADE[2]) &&
                !tipo.equalsIgnoreCase(Utils.TIPO_HABILIDADE[3]) &&
                !tipo.equalsIgnoreCase(Utils.TIPO_HABILIDADE[4]) &&
                !tipo.equalsIgnoreCase(Utils.TIPO_HABILIDADE[5]) &&
                !tipo.equalsIgnoreCase(Utils.TIPO_HABILIDADE[6])) {
            throw new TipoHabilidadeInvalidoException(
                    "Tipo de habilidade informada inválida! Por favor, insira apenas as opções: " +
                            "Física, Intelectual, Musical, Emocional, Intuitiva ou Outro."
            );
        }
        else {
            this.tipo = tipo;
        }
    }
}
