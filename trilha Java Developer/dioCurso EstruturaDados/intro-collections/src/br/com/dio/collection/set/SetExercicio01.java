package br.com.dio.collection.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetExercicio01 {

	public static void main(String[] args) {
		// 1. Crie um conjunto contendo as cores do arco-íris
		Set<String> cores = new TreeSet<>(
				Arrays.asList("vermelho", "laranja", "amarelo", "verde", "azul", "anil", "violeta"));

		// 2. Exiba todas as cores uma abaixo da outra
		System.out.println("Cores do arco-íris:");
		for (String cor : cores) {
			System.out.println(cor);
		}

		// 3. A quantidade de cores que o arco-íris tem
		System.out.println("\nQuantidade de cores: " + cores.size());

		// 4. Exiba as cores em ordem alfabética
		// (TreeSet já mantém as cores em ordem alfabética)
		System.out.println("\nCores em ordem alfabética:");
		for (String cor : cores) {
			System.out.println(cor);
		}

		// 5. Exiba as cores na ordem inversa da que foi informada
		List<String> coresInvertidas = new ArrayList<>(cores);
		Collections.reverse(coresInvertidas);
		System.out.println("\nCores na ordem inversa:");
		for (String cor : coresInvertidas) {
			System.out.println(cor);
		}

		// 6. Exiba todas as cores que começam com a letra “v”
		System.out.println("\nCores que começam com a letra 'v':");
		for (String cor : cores) {
			if (cor.startsWith("v")) {
				System.out.println(cor);
			}
		}

		// 7. Remova todas as cores que não começam com a letra “v”
		cores.removeIf(cor -> !cor.startsWith("v"));
		System.out.println("\nCores após remoção das que não começam com 'v':");
		for (String cor : cores) {
			System.out.println(cor);
		}

		// 8. Limpe o conjunto
		cores.clear();
		System.out.println("\nConjunto limpo.");

		// 9. Confira se o conjunto está vazio
		System.out.println("O conjunto está vazio? " + cores.isEmpty());
	}

}
