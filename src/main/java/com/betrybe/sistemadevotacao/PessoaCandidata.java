package com.betrybe.sistemadevotacao;

/**
 * Classe Pessoa candidata.
 */

public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /**
   * Constructor.
   */

  public PessoaCandidata(String nome, int numero) {
    super.nome = nome;
    this.setNumero(numero);
    this.setVotos(0);
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }

  public void receberVoto() {
    votos += 1;
  }
}
