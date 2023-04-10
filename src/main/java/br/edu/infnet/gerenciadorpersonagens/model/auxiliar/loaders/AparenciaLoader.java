package br.edu.infnet.gerenciadorpersonagens.model.auxiliar.loaders;

import br.edu.infnet.gerenciadorpersonagens.model.auxiliar.Utils;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Aparencia;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Log;
import br.edu.infnet.gerenciadorpersonagens.model.service.AparenciaService;
import br.edu.infnet.gerenciadorpersonagens.model.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Order(3)
@Component
public class AparenciaLoader implements ApplicationRunner {

    private final AparenciaService aparenciaService;
    private final LogService logService;

    @Autowired
    public AparenciaLoader(AparenciaService aparenciaService, LogService logService) {
        this.aparenciaService = aparenciaService;
        this.logService = logService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String dir = "src/main/java/br/edu/infnet/gerenciadorpersonagens/model/auxiliar/";
        String arq = "AparenciaMock";

        try {
            FileReader fileR = new FileReader(dir+arq);
            BufferedReader leituraArquivo = new BufferedReader(fileR);

            //int i = 0;
            String linha = leituraArquivo.readLine();
            String[] camposPorLinha;
            while (linha != null) {
                camposPorLinha = linha.split(";");
                Aparencia aparencia = new Aparencia(
                        camposPorLinha[0],
                        camposPorLinha[1],
                        camposPorLinha[2],
                        Double.parseDouble(camposPorLinha[3]),
                        Double.parseDouble(camposPorLinha[4]),
                        camposPorLinha[5],
                        camposPorLinha[6],
                        camposPorLinha[7],
                        camposPorLinha[8],
                        camposPorLinha[9]
                );

                Criador criador = new Criador();
                criador.setId(Integer.parseInt(camposPorLinha[10]));
                aparencia.setCriador(criador);
                aparenciaService.incluir(aparencia);

                String msgLog = "Cadastrada Aparência " + aparencia.getPontoDeDestaque() + " com id " + aparenciaService.obterPorId(aparencia.getId()).getId();

                Log log = new Log("192.168.29.107", Utils.TIPO_ACAO_LOG[0], msgLog, criador);
                logService.incluir(log);

                System.out.println("Inclusão da aparência estilo " + aparencia.getInspiracao() + " realizada com sucesso!");
                linha = leituraArquivo.readLine();
            }
            leituraArquivo.close();
            fileR.close();
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }
    }
}
