package br.com.dio.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio01 {

	// Receber a temperatura média dos 6 primeiros meses do ano e armazenar em uma
	// lista.
	// Calcular a média semestral das temperaturas e mostrar todas as temperaturas
	// acima desta média,
	// e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 –
	// Fevereiro e etc).

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			List<Double> temperaturaSemestre = new ArrayList<Double>();

			double soma = 0.0;

			for (int i = 1; i <= 6; i++) {
				System.out.println("Digite a temperatura do mês " + i + ":");
				double temp = scanner.nextDouble();
				temperaturaSemestre.add(temp);
				soma += temp;
			}

			double mediaTemperaturaSemestre = soma / temperaturaSemestre.size();

			System.out.println("Temperaturas Semestral: " + temperaturaSemestre);
			System.out.println("Média temperaturas Semestre: " + mediaTemperaturaSemestre + "ºC");
			System.out.println("----------------------------------------------");

			for (Double temp : temperaturaSemestre) {
				if (temp > mediaTemperaturaSemestre) {
					int index = temperaturaSemestre.indexOf(temp);
					switch (index) {
					case 0:
						System.out.println((index + 1) + " -Janeiro: " + temp + "ºC");
						break;
					case 1:
						System.out.println((index + 1) + " -Fevereiro: " + temp + "ºC");
						break;
					case 2:
						System.out.println((index + 1) + " -Março: " + temp + "ºC");
						break;
					case 3:
						System.out.println((index + 1) + " -Abril: " + temp + "ºC");
						break;
					case 4:
						System.out.println((index + 1) + " -Maio: " + temp + "ºC");
						break;
					case 5:
						System.out.println((index + 1) + " -Junho: " + temp + "ºC");
					default:
						break;
					}
				}
			}
		}
	}
}
