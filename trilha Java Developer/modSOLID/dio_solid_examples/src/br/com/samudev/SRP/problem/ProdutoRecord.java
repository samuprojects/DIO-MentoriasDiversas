package br.com.samudev.SRP.problem;

import java.math.BigDecimal;

// versão do problema da ordem de compra candidata à "god class" utilizando Record para o Produto

public record ProdutoRecord(String nome, BigDecimal valor) {

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}
