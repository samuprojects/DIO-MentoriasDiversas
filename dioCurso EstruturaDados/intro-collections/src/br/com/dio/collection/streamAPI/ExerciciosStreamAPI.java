package br.com.dio.collection.streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {

	public static void main(String[] args) {
		List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");
        numerosAleatorios.stream()
                 .forEach(System.out::println); // poderia usar ainda só o lambda ou chamando o accept comom mostrado na aula
        System.out.println("****************************************************");
        System.out.println();
        
        numerosAleatorios.forEach(System.out::println); // simplificação sugerida pela IDE utilizando method reference
        System.out.println("****************************************************");
        System.out.println();

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set:");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println();
        
        // outra opção utilizando uma variável diferente
        Set<String> numerosAleatorios5Primeiros = numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet());
        System.out.println(numerosAleatorios5Primeiros);
        System.out.println("****************************************************");
        System.out.println();

        System.out.println("Transforme esta lista de String em uma lista de números inteiros.");
        numerosAleatorios.stream()
                .map(Integer::parseInt).collect(Collectors.toList())
                .forEach(System.out::println); // outra opção anterior é utilizando e sobrescrevendo o método apply, porém, pouco utilizado
		System.out.println("****************************************************");
        System.out.println();
        
        // outra opção utilizando uma variável diferente (utilizado na remoção da aula stream parte 3)
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream().map(Integer::parseInt)
				.collect(Collectors.toList());
        

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista:");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();
        
        // outra opção utilizando uma variável diferente
        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> (i % 2 == 0 && i > 2))
                .collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);
        System.out.println("****************************************************");
        System.out.println();

        System.out.println("Mostre a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);
        System.out.println("****************************************************");
        System.out.println();

        // como stream não altera a fonte de dados a seguir utilizará outra variável da aula parte2 numerosAleatoriosInteger
        System.out.println("Remova os valores ímpares: ");
        numerosAleatoriosInteger.removeIf(integer -> integer % 2 != 0);
        System.out.println(numerosAleatoriosInteger);
        System.out.println();
        
        // outra forma de escrever a mesma coisa no lambda em relação ao nome e parenteses dentro do removeIf
        numerosAleatoriosInteger.removeIf(i -> (i % 2 != 0));
        System.out.println(numerosAleatoriosInteger);
        System.out.println("****************************************************");
        System.out.println();

        // Para exercitar
		System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
		numerosAleatoriosInteger.stream().skip(3).forEach(System.out::println);
		System.out.println("****************************************************");
        System.out.println();

		long countNumerosUnicos = numerosAleatoriosInteger.stream().distinct().count();
		System.out.println("Retirando os números repetidos da lista, quantos números ficam? \n" + countNumerosUnicos);
		System.out.println("****************************************************");
        System.out.println();

		System.out.print("Mostre o menor valor da lista: ");
		numerosAleatoriosInteger.stream().mapToInt(Integer::intValue).min().ifPresent(System.out::println);
		System.out.println("****************************************************");
        System.out.println();

		System.out.print("Mostre o maior valor da lista: ");
		numerosAleatoriosInteger.stream().mapToInt(Integer::intValue).max().ifPresent(System.out::println);
		System.out.println("****************************************************");
        System.out.println();

		int somaDosNumerosPares = numerosAleatoriosInteger.stream().filter(i -> (i % 2 == 0))
				.mapToInt(Integer::intValue).sum();
		System.out.println("Pegue apenas os números pares e some: " + somaDosNumerosPares);
		System.out.println("****************************************************");
        System.out.println();

		System.out.println("Mostre a lista na ordem númerica: ");
		List<Integer> numerosOrdemNatural = numerosAleatoriosInteger.stream().sorted(Comparator.naturalOrder())
				.collect(Collectors.toList());
		System.out.println(numerosOrdemNatural);
		System.out.println("****************************************************");
        System.out.println();

		System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
//        dica: collect(Collectors.groupingBy(new Function())
		Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = numerosAleatoriosInteger.stream()
				.collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
		System.out.println(collectNumerosMultiplosDe3E5);
		System.out.println("****************************************************");
        System.out.println();
	}
}