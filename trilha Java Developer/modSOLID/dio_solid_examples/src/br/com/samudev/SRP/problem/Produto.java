package br.com.samudev.SRP.problem;

import java.math.BigDecimal;

// IDE sugere transformar em Record, testado em ProdutoRecord

public class Produto {

    private final String nome;
    private final BigDecimal valor;

    public Produto(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}
