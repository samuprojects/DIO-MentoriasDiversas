package br.com.dio.collection.map;

import java.util.*;

	/*
	Faça um programa que simule um lançamento de um dado. Lance o dado 100 vezes e armazene.
	Depois, mostre quantas vezes cada valor do dado foi conseguido.
	 */

public class MapExercicio02 {
    public static void main(String[] args) {
        int quantLancamentos = 100;

        List<Integer> valores = new ArrayList<>();
        Random geradorDeLancamento = new Random();
        for (int i = 0; i < quantLancamentos; i++) {
            int number = geradorDeLancamento.nextInt(6) + 1;
            valores.add(number);
        }

        Map<Integer, Integer> lancamentos = new HashMap<>();
        for (Integer resultado : valores) {
            if (lancamentos.containsKey(resultado))
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1));
            else lancamentos.put(resultado, 1);
        }

        System.out.print("Jogando o dado 100 vezes"); // parte "gráfica" para dar a entender ao jogador que está "em movimento"
        // for + try/cath -> é opcional para fazer aparecer os "pontos" do carregamento
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(3000); // após esse tempo coloca mais um ponto
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();

        System.out.println("\nDado no Valor" + "     Apareceu a quantidade de vezes abaixo");
        for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()) {
            System.out.printf("%6d %26d\n", entry.getKey(), entry.getValue());
        }
    }
}
