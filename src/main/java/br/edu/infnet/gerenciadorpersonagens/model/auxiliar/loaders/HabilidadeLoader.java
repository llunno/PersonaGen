package br.edu.infnet.gerenciadorpersonagens.model.auxiliar.loaders;

import br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Habilidade;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Log;
import br.edu.infnet.gerenciadorpersonagens.model.service.HabilidadeService;
import br.edu.infnet.gerenciadorpersonagens.model.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Order(4)
@Component
public class HabilidadeLoader implements ApplicationRunner {

    private final HabilidadeService habilidadeService;
    private final LogService logService;

    @Autowired
    public HabilidadeLoader(HabilidadeService habilidadeService, LogService logService) {
        this.habilidadeService = habilidadeService;
        this.logService = logService;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        String dir = "src/main/java/br/edu/infnet/gerenciadorpersonagens/model/auxiliar/";
        String arq = "HabilidadeMock";

        try {
            FileReader fileR = new FileReader(dir+arq);
            BufferedReader leituraArquivo = new BufferedReader(fileR);

            //int i = 0;
            String linha = leituraArquivo.readLine();
            String[] camposPorLinha;
            while (linha != null) {
                camposPorLinha = linha.split(";");
                Habilidade habilidade = new Habilidade(
                        camposPorLinha[0],
                        camposPorLinha[1],
                        camposPorLinha[2],
                        camposPorLinha[3],
                        camposPorLinha[4],
                        camposPorLinha[5]
                );
                Criador criador = new Criador();
                criador.setId(Integer.parseInt(camposPorLinha[6]));
                habilidade.setCriador(criador);
                habilidadeService.incluir(habilidade);

                String msgLog = "Cadastrada Habilidade " + habilidade.getPontoDeDestaque() + " com id " + habilidadeService.obterPorId(habilidade.getId()).getId();

                Log log = new Log("192.168.29.107", Utils.TIPO_ACAO_LOG[0], msgLog, criador);
                logService.incluir(log);

                System.out.println("Inclusão da habilidade " + habilidade.getNome() + " realizada com sucesso!");
                linha = leituraArquivo.readLine();
            }
            leituraArquivo.close();
            fileR.close();
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }
    }
}
