package br.com.dio.collection.streamAPI;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import br.com.dio.collection.map.exercicio3.Contato;

/*Dadas as seguintes informações  de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);

id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;
*/

@SuppressWarnings("all")
public class RefatoracaoOrdenacaoMap {

	public static void main(String[] args) {
		System.out.println("--\tOrdem aleatória\t--");
		Map<Integer, Contato> agenda = new HashMap<>() {
			{
				put(1, new Contato("Simba", 5555));
				put(4, new Contato("Cami", 1111));
				put(3, new Contato("Jon", 2222));
			}
		};
		System.out.println(agenda);
		agenda.forEach((key, value) -> System.out.println(key + " - " + value.getNome())); // trocado por lambda
		System.out.println("----------------------------------------------------");
		System.out.println();

		System.out.println("--\tOrdem Inserção\t--");
		Map<Integer, Contato> agenda1 = new LinkedHashMap<>(agenda);
		System.out.println(agenda1);
		agenda1.forEach((key, value) -> System.out.println(key + " - " + value.getNome())); // lambda
		System.out.println("----------------------------------------------------");
		System.out.println();

		System.out.println("--\tOrdem id\t--");
		Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
		System.out.println(agenda2);
		agenda2.forEach((key, value) -> System.out.println(key + " - " + value.getNome())); // lambda
		System.out.println("----------------------------------------------------");
		System.out.println();

		System.out.println("--\tOrdem número telefone\t--");
		Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(
				Comparator.comparing(entry -> entry.getValue().getNumero()));
		set.addAll(agenda.entrySet());
		set.forEach(entry -> System.out
				.println(entry.getKey() + " - " + entry.getValue().getNumero() + ": " + entry.getValue().getNome())); // lambda
		System.out.println("----------------------------------------------------");
		System.out.println();

		System.out.println("--\tOrdem nome contato\t--");
		Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(
				Comparator.comparing(entry -> entry.getValue().getNome(), String::compareToIgnoreCase)); // method reference
		set1.addAll(agenda.entrySet());
		set1.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue().getNome()));
	}
}