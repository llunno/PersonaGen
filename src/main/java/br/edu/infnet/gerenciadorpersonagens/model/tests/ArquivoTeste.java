package br.edu.infnet.gerenciadorpersonagens.model.tests;

import br.edu.infnet.gerenciadorpersonagens.model.domain.*;
import br.edu.infnet.gerenciadorpersonagens.model.exceptions.ExpressaoInvalidaException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoTeste {
    public static void main(String[] args) {
        String dir = "src/main/java/br/edu/infnet/gerenciadorpersonagens/model/auxiliar/";
        String arq = "ArquivoDados";

        try {
            FileReader fileR = new FileReader(dir+arq);
            BufferedReader leituraArquivo = new BufferedReader(fileR);

            FileWriter fileW = new FileWriter(dir + "out_" + arq);
            BufferedWriter escritaArquivo = new BufferedWriter(fileW);

            String linha = leituraArquivo.readLine();
            String[] camposPorLinha;

            Personagem personagem = new Personagem();
            ArrayList<Caracteristica> caracteristicasPersonagem = null;
            while (linha != null) {
                camposPorLinha = linha.split(";");
                switch (camposPorLinha[0].toUpperCase()) {
                    case "PERSONAGEM":
                        caracteristicasPersonagem = new ArrayList<>();

                        personagem.setCriador(new Criador(
                                camposPorLinha[1],
                                camposPorLinha[2],
                                Integer.parseInt(camposPorLinha[3]),
                                new ArrayList<>(List.of(camposPorLinha[4]))
                        ));
                        personagem.setCaracteristicas(caracteristicasPersonagem);
                        personagem.setNome(camposPorLinha[5]);
                        personagem.setIdade(Integer.parseInt(camposPorLinha[6]));
                        personagem.setHuman(Boolean.parseBoolean(camposPorLinha[7]));
                        personagem.setGenero(camposPorLinha[8]);
                        personagem.setHistoria(camposPorLinha[9]);
                        break;
                    case "PERSONALIDADE":
                        Personalidade personalidade = new Personalidade(camposPorLinha[1], camposPorLinha[2], camposPorLinha[3]);
                        personalidade.setPalavraDefinicao(camposPorLinha[4]);
                        try {
                            personalidade.setTipoExpressao(camposPorLinha[5]);
                        } catch (ExpressaoInvalidaException e) {
                            System.out.println(e.getMessage());
                        }
                        personalidade.setReligiao(camposPorLinha[6]);
                        personalidade.setTemperamento(camposPorLinha[7]);
                        personalidade.setQualidades(new ArrayList<>(List.of(camposPorLinha[8].split(","))));
                        personalidade.setDefeitos(new ArrayList<>(List.of(camposPorLinha[9].split(","))));
                        personalidade.setInteresses(new ArrayList<>(List.of(camposPorLinha[10].split(","))));
                        personalidade.setDesinteresses(new ArrayList<>(List.of(camposPorLinha[11].split(","))));
                        caracteristicasPersonagem.add(personalidade);
                        break;
                    case "APARENCIA":
                        Aparencia aparencia = new Aparencia(
                                camposPorLinha[1],
                                camposPorLinha[2],
                                camposPorLinha[3],
                                Double.parseDouble(camposPorLinha[4]),
                                Double.parseDouble(camposPorLinha[5]),
                                camposPorLinha[6],
                                camposPorLinha[7],
                                camposPorLinha[8],
                                camposPorLinha[9],
                                camposPorLinha[10]
                        );
                        caracteristicasPersonagem.add(aparencia);
                        break;
                    case "HABILIDADE":
                        Habilidade habilidade = new Habilidade(
                                camposPorLinha[1],
                                camposPorLinha[2],
                                camposPorLinha[3],
                                camposPorLinha[4],
                                camposPorLinha[5],
                                camposPorLinha[6]
                        );
                        caracteristicasPersonagem.add(habilidade);
                        break;
                    default:
                        System.out.println("Inexistente!!!");
                        break;
                }
                linha = leituraArquivo.readLine();
            }
            System.out.println("Personagem completo: " + personagem);
            escritaArquivo.write(personagem.gerarLinhaGravacao());
            leituraArquivo.close();
            fileR.close();
            escritaArquivo.close();
            fileW.close();
        } catch (IOException e) {
            System.out.println("Erro de leitura/grava????o no arquivo");
        }
    }
}
