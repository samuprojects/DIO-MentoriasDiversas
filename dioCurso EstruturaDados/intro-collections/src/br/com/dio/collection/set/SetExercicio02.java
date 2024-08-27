package br.com.dio.collection.set;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExercicio02 {
    public static void main(String[] args) {
        // Cria um conjunto com 3 linguagens
        Set<LinguagemFavorita> linguagens = new LinkedHashSet<>(Arrays.asList(
            new LinguagemFavorita("Java", 1995, "IntelliJ IDEA"),
            new LinguagemFavorita("Python", 1991, "PyCharm"),
            new LinguagemFavorita("JavaScript", 1995, "VS Code")
        ));

        // 1. Ordenar por Ordem de Inserção (já está na ordem de inserção com LinkedHashSet)
        System.out.println("Ordem de Inserção:");
        for (LinguagemFavorita linguagem : linguagens) {
            System.out.println(linguagem);
        }
        
        // 2. Ordenar por Ordem Natural (por nome)
        Set<LinguagemFavorita> porNome = new TreeSet<>(Comparator.comparing(LinguagemFavorita::getNome));
        porNome.addAll(linguagens);
        System.out.println("\nOrdem Natural (por Nome):");
        for (LinguagemFavorita linguagem : porNome) {
            System.out.println(linguagem);
        }
        
        // 3. Ordenar por IDE
        Set<LinguagemFavorita> porIde = new TreeSet<>(Comparator.comparing(LinguagemFavorita::getIde));
        porIde.addAll(linguagens);
        System.out.println("\nOrdenar por IDE:");
        for (LinguagemFavorita linguagem : porIde) {
            System.out.println(linguagem);
        }
        
        // 4. Ordenar por Ano de Criação e Nome
        Set<LinguagemFavorita> porAnoENome = new TreeSet<>(Comparator
            .comparingInt(LinguagemFavorita::getAnoDeCriacao)
            .thenComparing(LinguagemFavorita::getNome));
        porAnoENome.addAll(linguagens);
        System.out.println("\nOrdenar por Ano de Criação e Nome:");
        for (LinguagemFavorita linguagem : porAnoENome) {
            System.out.println(linguagem);
        }

        // 5. Ordenar por Nome, Ano de Criação e IDE
        Set<LinguagemFavorita> porNomeAnoIde = new TreeSet<>(Comparator
            .comparing(LinguagemFavorita::getNome)
            .thenComparingInt(LinguagemFavorita::getAnoDeCriacao)
            .thenComparing(LinguagemFavorita::getIde));
        porNomeAnoIde.addAll(linguagens);
        System.out.println("\nOrdenar por Nome, Ano de Criação e IDE:");
        for (LinguagemFavorita linguagem : porNomeAnoIde) {
            System.out.println(linguagem);
        }
    }
}
