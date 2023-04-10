package br.edu.infnet.gerenciadorpersonagens.model.auxiliar.loaders;


import br.edu.infnet.gerenciadorpersonagens.model.domain.*;
import br.edu.infnet.gerenciadorpersonagens.model.service.EntityServices;
import br.edu.infnet.gerenciadorpersonagens.model.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Order(8)
@Component
public class PersonagemLoader implements ApplicationRunner {

    private final PersonagemService personagemService;
    private final EntityServices entityServices;

    @Autowired
    public PersonagemLoader(PersonagemService personagemService, EntityServices entityServices) {
        this.personagemService = personagemService;
        this.entityServices = entityServices;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String dir = "src/main/java/br/edu/infnet/gerenciadorpersonagens/model/auxiliar/";
        String arq = "PersonagemMock";

        try {
            FileReader fileR = new FileReader(dir+arq);
            BufferedReader leituraArquivo = new BufferedReader(fileR);

            //int i = 0;
            String linha = leituraArquivo.readLine();
            String[] camposPorLinha;
            while (linha != null) {
                camposPorLinha = linha.split(";");
                Personagem personagem = new Personagem(
                        camposPorLinha[0],
                        Integer.parseInt(camposPorLinha[1]),
                        Boolean.parseBoolean(camposPorLinha[2]),
                        camposPorLinha[3],
                        camposPorLinha[4],
                        camposPorLinha[5]
                );

                Criador criador = new Criador();
                criador.setId(Integer.parseInt(camposPorLinha[6]));
                personagem.setCriador(criador);

                Personagem personagemFromDB = personagemService.incluir(personagem);

                String[] caracteristicaIds = camposPorLinha[7].split(",");
                Aparencia aparencia = entityServices.aparenciaService.obterPorId(Integer.parseInt(caracteristicaIds[0]));
                Personalidade personalidade = entityServices.personalidadeService.obterPorId(Integer.parseInt(caracteristicaIds[1]));
                Habilidade habilidade1 = entityServices.habilidadeService.obterPorId(Integer.parseInt(caracteristicaIds[2]));
                Habilidade habilidade2 = entityServices.habilidadeService.obterPorId(Integer.parseInt(caracteristicaIds[3]));

                List<Caracteristica> caracteristicas = List.of(aparencia, personalidade, habilidade1, habilidade2);
                List<Personagem> personagens = List.of(personagemFromDB);

                personagemFromDB.setCaracteristicas(caracteristicas);
                aparencia.setPersonagens(personagens);
                personalidade.setPersonagens(personagens);
                habilidade1.setPersonagens(personagens);
                habilidade2.setPersonagens(personagens);

                personagemService.incluir(personagemFromDB);
                entityServices.aparenciaService.incluir(aparencia);
                entityServices.personalidadeService.incluir(personalidade);
                entityServices.habilidadeService.incluir(habilidade1);
                entityServices.habilidadeService.incluir(habilidade2);

                System.out.println("Inclusão do personagem " + personagem.getNome() + " realizada com sucesso!");
                linha = leituraArquivo.readLine();
            }
            leituraArquivo.close();
            fileR.close();
        } catch (IOException e) {
            System.out.println("Erro de leitura no arquivo");
        }
    }
}
