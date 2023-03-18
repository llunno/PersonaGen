package br.edu.infnet.gerenciadorpersonagens.model.auxiliar;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Personalidade;
import br.edu.infnet.gerenciadorpersonagens.model.service.PersonalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonalidadeLoader implements ApplicationRunner {

    @Autowired
    private PersonalidadeService personalidadeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String dir = "src/main/java/br/edu/infnet/gerenciadorpersonagens/model/auxiliar/";
        String arq = "PersonalidadeMock";

        try {
            FileReader fileR = new FileReader(dir+arq);
            BufferedReader leituraArquivo = new BufferedReader(fileR);

            String linha = leituraArquivo.readLine();
            String[] camposPorLinha;
            while (linha != null) {
                camposPorLinha = linha.split(";");
                Personalidade personalidade = new Personalidade(
                        camposPorLinha[0],
                        camposPorLinha[1],
                        camposPorLinha[2],
                        camposPorLinha[3],
                        camposPorLinha[4],
                        camposPorLinha[5],
                        camposPorLinha[6],
                        new ArrayList<>(List.of(StringUtils.trimAllWhitespace(camposPorLinha[7]).split(","))),
                        new ArrayList<>(List.of(StringUtils.trimAllWhitespace(camposPorLinha[8]).split(","))),
                        new ArrayList<>(List.of(StringUtils.trimAllWhitespace(camposPorLinha[9]).split(","))),
                        new ArrayList<>(List.of(StringUtils.trimAllWhitespace(camposPorLinha[10]).split(",")))
                );
                personalidadeService.incluir(personalidade);
                System.out.println("Inclusão da personalidade " + personalidade.getPalavraDefinicao() + " realizada com sucesso!");
                linha = leituraArquivo.readLine();
            }
            leituraArquivo.close();
            fileR.close();
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }
    }
}
