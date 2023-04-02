package br.edu.infnet.gerenciadorpersonagens.model.domain;

import br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils;
import br.edu.infnet.gerenciadorpersonagens.model.exceptions.ExpressaoInvalidaException;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Personalidade extends Caracteristica{

    private String palavraDefinicao;
    private String tipoExpressao = "Não informado";
    private String religiao;
    private String temperamento;

    @ElementCollection
    private List<String> qualidades;
    @ElementCollection
    private  List<String> defeitos;
    @ElementCollection
    private List<String> interesses;
    @ElementCollection
    private List<String> desinteresses;

    public Personalidade() {}

    public Personalidade(
            String descricao,
            String pontoDeDestaque,
            String inspiracao,
            String palavraDefinicao,
            String tipoExpressao,
            String religiao,
            String temperamento,
            List<String> qualidades,
            List<String> defeitos,
            List<String> interesses,
            List<String> desinteresses
    ) {
        super(descricao,pontoDeDestaque,inspiracao);
        this.palavraDefinicao = palavraDefinicao;
        try {
            this.setTipoExpressao(tipoExpressao);
        } catch (ExpressaoInvalidaException e) {
            System.out.println("[ERRO]" + e.getMessage());
        }
        this.religiao = religiao;
        this.temperamento = temperamento;
        this.qualidades = qualidades;
        this.defeitos = defeitos;
        this.interesses = interesses;
        this.desinteresses = desinteresses;
    }

    @Override
    public String formatarExibicao() {
        StringBuilder stbuilder = new StringBuilder();
        return String.valueOf(stbuilder.append(palavraDefinicao).append(": ").append(getDescricao()));
    }

    @Override
    public String formatTelaCadastroPersonagem() {
        return "<strong>Palavra Definição</strong>: " + palavraDefinicao + ".<br>"
                + "<strong>Tipo de Expressão</strong>: " + tipoExpressao + ".<br>"
                + "<strong>Religião</strong>: " + religiao + ".<br>"
                + "<strong>Temperamento</strong>: " + temperamento + ".<br>"
                + "<strong>Qualidades</strong>: " + qualidades + ".<br>"
                + "<strong>Defeitos</strong>: " + defeitos + ".<br>"
                + "<strong>Interesses</strong>: " + interesses + ".<br>"
                + "<strong>Desinteresses</strong>: " + desinteresses + ".<br>"
                + "<strong>Descrição</strong>: " + getDescricao() + ".<br>"
                + "<strong>Ponto de Destaque</strong>: " + getPontoDeDestaque() + ".<br>"
                + "<strong>Inspiração</strong>: " + getInspiracao() + ".<br>";
    }

    @Override
    public String toString() {
        return super.toString()
                + ";" + palavraDefinicao
                + ";" + tipoExpressao
                + ";" + religiao
                + ";" + temperamento
                + ";" + qualidades
                + ";" + defeitos
                + ";" + interesses
                + ";" + desinteresses;
    }

    public void setTipoExpressao(String tipoExpressao) throws ExpressaoInvalidaException {
        if (!tipoExpressao.equalsIgnoreCase(Utils.TIPO_EXPRESSAO[0]) &&
                !tipoExpressao.equalsIgnoreCase(Utils.TIPO_EXPRESSAO[1]) &&
                !tipoExpressao.equalsIgnoreCase(Utils.TIPO_EXPRESSAO[2]) &&
                !tipoExpressao.equalsIgnoreCase(Utils.TIPO_EXPRESSAO[3])
        ) {
            throw new ExpressaoInvalidaException("Expressão inserida inválida! por favor, insira apenas Extrovertido ou Introvertido");
        }
        else {
            this.tipoExpressao = tipoExpressao;
        }
    }

}
