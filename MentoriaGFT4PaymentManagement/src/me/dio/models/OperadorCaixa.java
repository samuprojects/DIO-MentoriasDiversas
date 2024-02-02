package me.dio.models;

public class OperadorCaixa extends FuncionarioCLT {

	public OperadorCaixa(String nome, String documento, Double valorSalario, Endereco endereco) {
		super(nome, documento, valorSalario, endereco);
	}

	public OperadorCaixa() {
	}

	@Override
	public String toString() {
		return "OperadorCaixa [nome=" + nome + ", documento=" + documento + ", valorSalario=" + valorSalario
				+ ", endereco=" + endereco + "]";
	}

}
