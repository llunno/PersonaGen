package br.edu.infnet.gerenciadorpersonagens.model.auxiliar.loaders;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Administrador;
import br.edu.infnet.gerenciadorpersonagens.model.domain.Endereco;
import br.edu.infnet.gerenciadorpersonagens.model.service.AdministradorService;
import br.edu.infnet.gerenciadorpersonagens.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Order(1)
@Component
public class AdministradorLoader implements ApplicationRunner {

    private final AdministradorService administradorService;
    private final EnderecoService enderecoService;

    @Autowired
    public AdministradorLoader(AdministradorService administradorService, EnderecoService enderecoService) {
        this.administradorService = administradorService;
        this.enderecoService = enderecoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String dir = "src/main/java/br/edu/infnet/gerenciadorpersonagens/model/auxiliar/";
        String arq = "AdministradorMock";

        try {
            FileReader fileR = new FileReader(dir+arq);
            BufferedReader leituraArquivo = new BufferedReader(fileR);

            String linha = leituraArquivo.readLine();
            String[] camposPorLinha;
            while (linha != null) {
                camposPorLinha = linha.split(";");
                Administrador admin = new Administrador(
                        camposPorLinha[0],
                        camposPorLinha[1],
                        camposPorLinha[2],
                        camposPorLinha[3],
                        camposPorLinha[4],
                        camposPorLinha[5]
                );
                Endereco endereco = enderecoService.obterPorId(Integer.valueOf(camposPorLinha[6]));
                Administrador administradorRetornadoDB = administradorService.incluir(admin);
                administradorRetornadoDB.setEndereco(endereco);
                administradorService.incluir(administradorRetornadoDB);
                System.out.println("Inclusão do administrador " + admin.getNomeCompleto() + " realizada com sucesso!");
                linha = leituraArquivo.readLine();
            }
            leituraArquivo.close();
            fileR.close();
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }
    }
}
