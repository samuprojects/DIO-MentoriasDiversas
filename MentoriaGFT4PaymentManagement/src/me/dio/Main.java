package me.dio;

import me.dio.models.Endereco;
import me.dio.models.Gerente;
import me.dio.models.OperadorCaixa;
import me.dio.models.Vendedor;

public class Main {

	public static void main(String[] args) {

		Endereco enderecoGerente = new Endereco("Rua do gerente", "apto 11", "Lapa");
		Endereco enderecoVendedor = new Endereco("Rua do vendedor", "casa 20", "Conjunto Dois");
		Endereco enderecoOperadorCaixa = new Endereco("Rua do operador de caixa", "lote 5", "São João");

		System.out.format("%s\n%s\n%s\n", enderecoGerente, enderecoVendedor, enderecoOperadorCaixa);
		System.out.println("---------------------");

		Vendedor vendedor = new Vendedor();
		vendedor.setNome("Pedro Vendedor");
		vendedor.setDocumento("123.456.789-00");
		vendedor.setValorSalario(1000d);
		vendedor.setEndereco(enderecoVendedor);
		vendedor.calcularBonificacao(2d);
		System.out.println(vendedor);
		System.out.println("---------------------");

		OperadorCaixa operadorCaixa = new OperadorCaixa("João Op Caixa", "789.456.123-00", 2000d,
				enderecoOperadorCaixa);
		System.out.println(operadorCaixa);
		System.out.println("---------------------");

		Gerente gerente = new Gerente();
		gerente.setNome("Paulo Gerente");
		gerente.setDocumento("456.123.789-00");
		gerente.setEndereco(enderecoGerente);
		gerente.setHorasTrabalhadas(20);
		gerente.setValorHora(100d);
		gerente.calcularRemuneracao();
		gerente.calcularBonificacao(3d);
		System.out.println(gerente);
	}

}
