package br.edu.infnet.gerenciadorpersonagens.model.auxiliar.loaders;

import br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Log;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Personalidade;
import br.edu.infnet.gerenciadorpersonagens.model.service.LogService;
import br.edu.infnet.gerenciadorpersonagens.model.service.PersonalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Order(5)
@Component
public class PersonalidadeLoader implements ApplicationRunner {

    private final PersonalidadeService personalidadeService;
    private final LogService logService;

    @Autowired
    public PersonalidadeLoader(PersonalidadeService personalidadeService, LogService logService) {
        this.personalidadeService = personalidadeService;
        this.logService = logService;
    }

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
                        new ArrayList<>(List.of(camposPorLinha[7].trim().split(","))),
                        new ArrayList<>(List.of(camposPorLinha[8].trim().split(","))),
                        new ArrayList<>(List.of(camposPorLinha[9].trim().split(","))),
                        new ArrayList<>(List.of(camposPorLinha[10].trim().split(",")))
                );

                Criador criador = new Criador();
                criador.setId(Integer.parseInt(camposPorLinha[11]));
                personalidade.setCriador(criador);
                personalidadeService.incluir(personalidade);

                String msgLog = "Cadastrada personalidade " + personalidade.getPontoDeDestaque() + " com id " + personalidadeService.obterPorId(personalidade.getId()).getId();

                Log log = new Log("192.168.29.107", Utils.TIPO_ACAO_LOG[0], msgLog, criador);
                logService.incluir(log);

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
