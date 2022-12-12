package br.edu.infnet.gerenciadorpersonagens.model.domain;

import br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Constante;
import br.edu.infnet.gerenciadorpersonagens.model.exceptions.ExpressaoInvalidaException;

import java.util.ArrayList;

public class Personalidade extends Caracteristica{

    private String palavraDefinicao;
    private String tipoExpressao;
    private String religiao;
    private String temperamento;
    private ArrayList<String> qualidades;
    private  ArrayList<String> defeitos;
    private ArrayList<String> interesses;
    private ArrayList<String> desinteresses;

    public Personalidade(String descricao, String pontoDestaque, String inspiracao) {
        super(descricao,pontoDestaque,inspiracao);
    }

    public Personalidade(
            String descricao,
            String pontoDeDestaque,
            String inspiracao,
            String palavraDefinicao,
            String tipoExpressao,
            String religiao,
            String temperamento,
            ArrayList<String> qualidades,
            ArrayList<String> defeitos,
            ArrayList<String> interesses,
            ArrayList<String> desinteresses
    ) {
        super(descricao,pontoDeDestaque,inspiracao);
        this.palavraDefinicao = palavraDefinicao;
        this.tipoExpressao = tipoExpressao;
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



    public String getTipoExpressao() {
        return tipoExpressao;
    }

    public void setTipoExpressao(String tipoExpressao) throws ExpressaoInvalidaException {
        if (!tipoExpressao.equalsIgnoreCase(Constante.TIPO_EXPRESSAO[0]) &&
                !tipoExpressao.equalsIgnoreCase(Constante.TIPO_EXPRESSAO[1]) &&
                !tipoExpressao.equalsIgnoreCase(Constante.TIPO_EXPRESSAO[2]) &&
                !tipoExpressao.equalsIgnoreCase(Constante.TIPO_EXPRESSAO[3])
        ) {
            throw new ExpressaoInvalidaException("Expressão inserida inválida! por favor, insira apenas Extrovertido ou Introvertido");
        }
        else {
            this.tipoExpressao = tipoExpressao;
        }
    }

    public String getReligiao() {
        return religiao;
    }

    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public void setTemperamento(String temperamento) {
        this.temperamento = temperamento;
    }

    public ArrayList<String> getQualidades() {
        return qualidades;
    }

    public void setQualidades(ArrayList<String> qualidades) {
        this.qualidades = qualidades;
    }

    public ArrayList<String> getDefeitos() {
        return defeitos;
    }

    public void setDefeitos(ArrayList<String> defeitos) {
        this.defeitos = defeitos;
    }

    public ArrayList<String> getInteresses() {
        return interesses;
    }

    public void setInteresses(ArrayList<String> interesses) {
        this.interesses = interesses;
    }

    public ArrayList<String> getDesinteresses() {
        return desinteresses;
    }

    public void setDesinteresses(ArrayList<String> desinteresses) {
        this.desinteresses = desinteresses;
    }

    public String getPalavraDefinicao() {
        return palavraDefinicao;
    }

    public void setPalavraDefinicao(String palavraDefinicao) {
        this.palavraDefinicao = palavraDefinicao;
    }
}
