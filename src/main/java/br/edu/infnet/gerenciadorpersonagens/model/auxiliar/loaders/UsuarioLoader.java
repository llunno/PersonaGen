package br.edu.infnet.gerenciadorpersonagens.model.auxiliar.loaders;

import br.edu.infnet.gerenciadorpersonagens.model.domain.Usuario;
import br.edu.infnet.gerenciadorpersonagens.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class UsuarioLoader implements ApplicationRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String dir = "src/main/java/br/edu/infnet/gerenciadorpersonagens/model/auxiliar/";
        String arq = "UsuarioMock";

        try {
            FileReader fileR = new FileReader(dir+arq);
            BufferedReader leituraArquivo = new BufferedReader(fileR);

            String linha = leituraArquivo.readLine();
            String[] camposPorLinha;
            while (linha != null) {
                camposPorLinha = linha.split(";");
                Usuario usuario = new Usuario(
                        camposPorLinha[0],
                        camposPorLinha[1],
                        camposPorLinha[2],
                        camposPorLinha[3]
                );
                usuarioService.incluir(usuario);
                System.out.println("Inclusão do usuário " + usuario.getNomeCompleto() + " realizada com sucesso!");
                linha = leituraArquivo.readLine();
            }
            leituraArquivo.close();
            fileR.close();
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }
    }
}
