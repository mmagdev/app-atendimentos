package br.com.cotiinformatica.services;

import br.com.cotiinformatica.entities.Atendimento;

import java.util.Scanner;

public class AtendimentoService {

    /*
    Método para fazer a captura dos dados
    do usuário e gerar um atendimento
     */

    public void realizarAtendimento() {

        try {

            var atendimento = new Atendimento();
            var scanner = new Scanner(System.in);

            System.out.println("Informe o nome para atendimento: ");
            atendimento.setUsuario(scanner.nextLine());

            System.out.println("Digite a sua pergunta: ");
            atendimento.setPergunta(scanner.nextLine());

            System.out.println("\nProcessando Resposta...\n");

        }
        catch(Exception e) {
            System.out.println("\nFalha: " + e.getMessage());
        }
    }
}
