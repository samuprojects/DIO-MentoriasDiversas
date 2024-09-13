package br.com.samudev.SRP.problem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// Exemplo de classe candidata à "god class" com base na classe Produto

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

    public List<OrdemDeCompra> buscarOrdensDeCompra() {
        List<OrdemDeCompra> ordens = new ArrayList<>();

        OrdemDeCompra ordem1 = new OrdemDeCompra();
        ordem1.adicionarProduto(new Produto("Produto 1", BigDecimal.valueOf(100.00)));
        ordem1.adicionarProduto(new Produto("Produto 2", BigDecimal.valueOf(50.00)));

        OrdemDeCompra ordem2 = new OrdemDeCompra();
        ordem2.adicionarProduto(new Produto("Produto A", BigDecimal.valueOf(30.00)));
        ordem2.adicionarProduto(new Produto("Produto B", BigDecimal.valueOf(20.00)));

        ordens.add(ordem1);
        ordens.add(ordem2);

        return ordens;
    }

    public void salvarOrdemCompra() {
        System.out.println("Ordem de compra salva com sucesso!");
    }

    public void alterarOrdemDeCompra(int indice, Produto novoProduto) {
        if (indice >= 0 && indice < produtos.size()) {
            produtos.set(indice, novoProduto);
            System.out.println("Produto na posição " + indice + " alterado para: " + novoProduto);
        } else {
            System.out.println("Índice inválido. Não foi possível alterar o produto.");
        }
    }

    public Produto buscarProdutoPorNome(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null; // Produto não encontrado
    }

    public void enviarEmail(String email) {
        System.out.println("E-mail enviado para: " + email);
        System.out.println("Detalhes da ordem de compra:\n" + this);
    }

    public void imprimirOrdemDeCompra() {
        System.out.println("Detalhes da Ordem de Compra:");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
        System.out.println("Total: " + calcularTotal());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrdemDeCompra{\n");
        for (Produto produto : produtos) {
            sb.append("  ").append(produto).append("\n");
        }
        sb.append("  Total=").append(calcularTotal()).append("\n");
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        OrdemDeCompra ordem = new OrdemDeCompra();

        ordem.adicionarProduto(new Produto("Produto A", BigDecimal.valueOf(30.00)));
        ordem.adicionarProduto(new Produto("Produto B", BigDecimal.valueOf(20.00)));

        System.out.println("Antes da alteração:");
        ordem.imprimirOrdemDeCompra();

        ordem.alterarOrdemDeCompra(1, new Produto("Produto C", BigDecimal.valueOf(25.00)));

        System.out.println("\nDepois da alteração:");
        ordem.imprimirOrdemDeCompra();

        String nomeBusca = "Produto C";
        Produto produtoEncontrado = ordem.buscarProdutoPorNome(nomeBusca);
        if (produtoEncontrado != null) {
            System.out.println("\nProduto encontrado: " + produtoEncontrado);
        } else {
            System.out.println("\nProduto com o nome '" + nomeBusca + "' não encontrado.");
        }

        ordem.removerProduto(produtoEncontrado);

        System.out.println("\nApós a remoção do produto:");
        ordem.imprimirOrdemDeCompra();

        ordem.salvarOrdemCompra();

        ordem.enviarEmail("cliente@example.com");

        System.out.println("\nBuscando ordens de compra:");
        List<OrdemDeCompra> ordens = ordem.buscarOrdensDeCompra();
        for (int i = 0; i < ordens.size(); i++) {
            System.out.println("\nOrdem de Compra " + (i + 1) + ":");
            ordens.get(i).imprimirOrdemDeCompra();
        }
    }
}
