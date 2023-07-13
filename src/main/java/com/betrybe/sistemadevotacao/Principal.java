package com.betrybe.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /**
   * Class Principal.
   */

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    setCandidatos(scanner, gerenciamentoVotacao);
    setEleitoras(scanner, gerenciamentoVotacao);
    votacao(scanner, gerenciamentoVotacao);
  }

  private static void options() {
    System.out.println("1 - Sim");
    System.out.println("2 - Não");
    System.out.print("Entre com o número correspondente à opção desejada: ");
  }

  private static void setCandidatos(Scanner scanner, GerenciamentoVotacao gerenciamentoVotacao) {
    int input;
    do {
      System.out.println("Cadastrar pessoa candidata?");
      options();
      input = Integer.parseInt(scanner.next());
      if (input == 1) {
        System.out.print("Entre com o nome da pessoa candidata: ");
        String nome = scanner.next();
        System.out.print("Entre com o número da pessoa candidata: ");
        int numero = Integer.parseInt(scanner.next());
        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
      }
    } while (input != 2);
  }

  private static void setEleitoras(Scanner scanner, GerenciamentoVotacao gerenciamentoVotacao) {
    int input;
    do {
      System.out.println("Cadastrar pessoa eleitora?");
      options();
      input = Integer.parseInt(scanner.next());
      if (input == 1) {
        System.out.print("Entre com o nome da pessoa eleitora: ");
        String nome = scanner.next();
        System.out.print("Entre com o cpf da pessoa eleitora: ");
        String cpf = scanner.next();
        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      }
    } while (input != 2);
  }

  private static void votacao(Scanner scanner, GerenciamentoVotacao gerenciamentoVotacao) {
    int input;
    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      input = Integer.parseInt(scanner.next());
      if (input == 1) {
        System.out.print("Entre com o cpf da pessoa eleitora: ");
        String cpf = scanner.next();
        System.out.print("Entre com o número da pessoa candidata: ");
        int numero = Integer.parseInt(scanner.next());
        gerenciamentoVotacao.votar(cpf, numero);
      } else {
        gerenciamentoVotacao.mostrarResultado();
      }
    } while (input != 3);
  }
}


