package com.betrybe.sistemadevotacao;

/**
 * Class PessoaEleitora.
 */

public class PessoaEleitora extends Pessoa {
  private String cpf;

  /**
   * Constructor.
   */

  public PessoaEleitora(String nome, String cpf) {
    super.nome = nome;
    this.setCpf(cpf);
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
