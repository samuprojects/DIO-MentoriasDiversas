package br.com.samudev.SRP.solution;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrdemDeCompra {

    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public BigDecimal calcularTotal() {
        return produtos.stream()
                .map(Produto::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
