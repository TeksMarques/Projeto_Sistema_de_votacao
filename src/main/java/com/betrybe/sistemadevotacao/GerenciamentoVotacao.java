package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * Class GerenciamentoVotacao.
 */

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /**
   * Constructor.
   */

  public GerenciamentoVotacao() {
    this.cpfsComputados = new ArrayList<>();
    this.pessoasCandidatas = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
  }

  /**
   * Method auxiliary numeroExiste.
   */

  private boolean numeroExiste(int numero) {
    return pessoasCandidatas.stream().anyMatch(candidata -> candidata.getNumero() == numero);
  }

  /**
   * Method cadastrarPessoaCandidata.
   */

  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (numeroExiste(numero)) {
      System.out.println("Número da pessoa candidata já utilizado!");
      return;
    }

    PessoaCandidata novoCandidato = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(novoCandidato);
  }

  /**
   * Method auxiliary cpfCadastrado.
   */

  private boolean cpfCadastrado(String cpf) {
    return pessoasEleitoras.stream().anyMatch(eleitora -> eleitora.getCpf().equals(cpf));
  }

  /**
   * Method cadastrarPessoaEleitora.
   */

  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (cpfCadastrado(cpf)) {
      System.out.println("Pessoa eleitora já cadastrada!");
      return;
    }

    PessoaEleitora novoEleitor = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(novoEleitor);
  }

  /**
   * Method auxiliary buscarPessoaCandidata.
   */

  private PessoaCandidata buscarPessoaCandidata(int numeroPessoaCandidata) {
    return pessoasCandidatas.stream()
        .filter(candidata -> candidata.getNumero() == numeroPessoaCandidata).findFirst()
        .orElse(null);
  }

  /**
   * Method votar.
   */

  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfsComputados.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }

    PessoaCandidata candidato = buscarPessoaCandidata(numeroPessoaCandidata);
    if (candidato == null) {
      System.out.println("Número da pessoa candidata inválido");
    }

    candidato.receberVoto();
    cpfsComputados.add(cpfPessoaEleitora);
  }

  /**
   * Method mostrarResultado.
   */

  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }

    StringBuilder output = new StringBuilder();
    output.append("Resultado da eleição:\n");
    for (PessoaCandidata candidato : pessoasCandidatas) {
      int votos = candidato.getVotos();
      double percentual = (votos * 100.0) / cpfsComputados.size();
      output.append("Nome: ").append(candidato.getNome()).append(" - ").append(votos)
          .append(" votos (").append(Math.round(percentual)).append("%)\n");
    }
    output.append("Total de votos: ").append(cpfsComputados.size());


    String expectedOutput = output.toString().trim();

    System.out.println(expectedOutput);
  }
}
