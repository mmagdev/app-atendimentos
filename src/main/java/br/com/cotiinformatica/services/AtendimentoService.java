package br.com.cotiinformatica.services;

import br.com.cotiinformatica.agents.OpenAiClient;
import br.com.cotiinformatica.entities.Atendimento;
import br.com.cotiinformatica.repositories.AtendimentoRepository;

import java.util.Scanner;
import java.util.UUID;

public class AtendimentoService {

    /*
    Método para fazer a captura dos dados
    do usuário e gerar um atendimento
     */

    public void realizarAtendimento() {

        try {

            var atendimento = new Atendimento();
            atendimento.setId(UUID.randomUUID());

            var atendimentoRepository = new AtendimentoRepository();
            var openAiClient = new OpenAiClient();

            var scanner = new Scanner(System.in);

            System.out.println("Informe o nome para atendimento: ");
            atendimento.setUsuario(scanner.nextLine());

            System.out.println("Digite a sua pergunta: ");
            atendimento.setPergunta(scanner.nextLine());

            System.out.println("\nProcessando Resposta...\n");

            //Enviando a pergunta para a IA e obtendo a resposta
            var resposta = openAiClient.perguntar(atendimento.getUsuario(), atendimento.getPergunta());
            atendimento.setResposta(resposta);

            //Imprimindo a resposta para o usuário
            System.out.println("Resposta: \n");
            System.out.println(atendimento.getResposta());

            //Salvando no banco de dados
            atendimentoRepository.inserir(atendimento);

        }
        catch(Exception e) {
            System.out.println("\nFalha: " + e.getMessage());
        }
    }
}
