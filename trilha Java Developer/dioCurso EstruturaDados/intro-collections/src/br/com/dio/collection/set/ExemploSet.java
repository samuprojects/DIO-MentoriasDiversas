package br.com.dio.collection.set;

import java.util.*;

public class ExemploSet {
	public static void main(String[] args) {
		
		// lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], realizar:

		//      Set notas = new HashSet(); // realizado antes do java 5
		//      HashSet<Double> notas = new HashSet<>();
		
		//      Set<Double> notas = new HashSet<>(); // com Generics(no jdk 5) - Diamond Operator(no jdk 7)
		
		/*
		 * Set<Double> notas = Set.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); notas.add(1d);
		 * notas.remove(5d); System.out.println(notas);
		 */

		System.out.println("Crie um conjunto e adicione as notas: ");
		Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6)); // exibição será aleatória e com elementos repetidos
		System.out.println(notas.toString());
		System.out.println();

        System.out.println("Exiba a posição da nota 5.0: "); // não é possível porque não tem índice
        System.out.println();

        System.out.println("Adicione na lista a nota 8.0 na posição 4: "); // também não é possível
        System.out.println();

        System.out.println("Substitua a nota 5.0 pela nota 6.0: "); // também não é possível alteração
        System.out.println();

		System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));
		System.out.println();

        System.out.println("Exiba a terceira nota adicionada: "); // também não é possível
        System.out.println();

		System.out.println("Exiba a menor nota: " + Collections.min(notas));
		System.out.println();

		System.out.println("Exiba a maior nota: " + Collections.max(notas));
		System.out.println();

		// para fazer a soma dos valores
		Iterator<Double> iterator = notas.iterator();
		Double soma = 0.0;
		while (iterator.hasNext()) {
			Double next = iterator.next();
			soma += next;
		}
		System.out.println("Exiba a soma dos valores: " + soma);
		System.out.println();

		System.out.println("Exiba a média das notas: " + (soma / notas.size()));
		System.out.println();

		System.out.println("Remova a nota 0: ");
		notas.remove(0d);
		System.out.println(notas);
		System.out.println();

        System.out.println("Remova a nota da posição 0"); // não é possível trabalhar com índices
        System.out.println();

		System.out.println("Remova as notas menores que 7 e exiba a lista: ");
		Iterator<Double> iterator1 = notas.iterator();
		while (iterator1.hasNext()) {
			Double next = iterator1.next();
			if (next < 7)
				iterator1.remove();
		}
		System.out.println(notas);
		System.out.println();

		System.out.println("Exiba todas as notas na ordem em que foram informados: ");
		Set<Double> notas2 = new LinkedHashSet<>();
		notas2.add(7d);
		notas2.add(8.5);
		notas2.add(9.3);
		notas2.add(5d);
		notas2.add(7d); // elementos duplicados não vão aparecer
		notas2.add(0d);
		notas2.add(3.6);
		System.out.println(notas2);
		System.out.println();

		System.out.println("Exiba todas as notas na ordem crescente: ");
		Set<Double> notas3 = new TreeSet<>(notas2); // poderia usar um for se não quisesse usar as collections
		System.out.println(notas3); // funciona aqui a ordenação poque a classe Double possui um Comparable, se fosse o contrário e não passase um Comparator também não funcionaria
		System.out.println();

		System.out.println("Apague todo o conjunto");
		notas.clear();
		System.out.println();

		System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());
		System.out.println();
		
		System.out.println("Confira se o conjunto 2 está vazio: " + notas2.isEmpty());
		System.out.println();
		
		System.out.println("Confira se o conjunto 3 está vazio: " + notas3.isEmpty());

	}
}