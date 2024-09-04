package br.com.dio.collection.set;

import java.util.Comparator;

public class ComparatorTempoEpisodio implements Comparator<Serie> {
	
	@Override
    public int compare(Serie s1, Serie s2) {
        int nome = s2.getNome().compareTo(s1.getNome());
        if (nome != 0) return nome;

        return Integer.compare(s2.getTempoEpisodio(), s1.getTempoEpisodio());
    }

}
