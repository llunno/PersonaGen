package br.edu.infnet.gerenciadorpersonagens.model.auxiliar.loaders;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Criador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Endereco;
import br.edu.infnet.gerenciadorpersonagens.model.service.CriadorService;
import br.edu.infnet.gerenciadorpersonagens.model.service.EnderecoService;
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

@Order(2)
@Component
public class CriadorLoader implements ApplicationRunner {

    private final CriadorService criadorService;
    private final EnderecoService enderecoService;

    @Autowired
    public CriadorLoader(CriadorService criadorService, EnderecoService enderecoService) {
        this.criadorService = criadorService;
        this.enderecoService = enderecoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String dir = "src/main/java/br/edu/infnet/gerenciadorpersonagens/model/auxiliar/";
        String arq = "CriadorMock";

        try {
            FileReader fileR = new FileReader(dir+arq);
            BufferedReader leituraArquivo = new BufferedReader(fileR);

            //int i = 0;
            String linha = leituraArquivo.readLine();
            String[] camposPorLinha;
            while (linha != null) {
                camposPorLinha = linha.split(";");
                Criador criador = new Criador(
                        camposPorLinha[0],
                        camposPorLinha[1],
                        camposPorLinha[2],
                        camposPorLinha[3],
                        camposPorLinha[4],
                        new ArrayList<>(List.of(camposPorLinha[5].split(",")))

                );
                Endereco endereco = enderecoService.obterPorId(Integer.valueOf(camposPorLinha[6]));
                Criador criadorRetornadoDB = criadorService.incluir(criador);
                criadorRetornadoDB.setEndereco(endereco);
                criadorService.incluir(criadorRetornadoDB);
                System.out.println("Inclusão do Criador " + criador.getNomeCompleto() + " realizada com sucesso!");
                linha = leituraArquivo.readLine();
            }
            leituraArquivo.close();
            fileR.close();
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }
    }
}
