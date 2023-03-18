package br.edu.infnet.gerenciadorpersonagens.model.auxiliar;

import java.util.List;

public class Utils {
    public static final String[] TIPO_FISICO = new String[]{"Ectomorfo", "Mesomorfo", "Endomorfo"};
    public static final String[] TIPO_HABILIDADE = new String[]{"Física", "Fisica","Intelectual", "Musical", "Emocional", "Intuitiva", "Outros"};
    public static final String[] TIPO_EXPRESSAO = new String[]{"Introvertido", "Extrovertido", "Introvertida", "Extrovertida"};

    public static String concatenarExibicaoLista(List<String> lista) {
        StringBuilder stbuilder = new StringBuilder();
        for (String item : lista) {
            stbuilder.append(item).append(", ");

            if (lista.indexOf(item) == lista.size() - 1) {
                stbuilder.delete(stbuilder.length() - 2, stbuilder.length());
            }
        }
        return stbuilder.toString();
    }
}
