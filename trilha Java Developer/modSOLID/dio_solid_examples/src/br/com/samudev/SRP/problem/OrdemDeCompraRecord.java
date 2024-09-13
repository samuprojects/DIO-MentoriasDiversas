package br.com.samudev.SRP.problem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// Exemplo de classe candidata à "god class" com base no Record Produto

public class OrdemDeCompraRecord {

    private final List<ProdutoRecord> produtos = new ArrayList<>();

    public void adicionarProduto(ProdutoRecord produto) {
        produtos.add(produto);
    }

    public void removerProduto(ProdutoRecord produto) {
        produtos.remove(produto);
    }

    public BigDecimal calcularTotal() {
        return produtos.stream()
                .map(ProdutoRecord::valor) // Acesso ao campo 'valor' diretamente
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<OrdemDeCompraRecord> buscarOrdensDeCompra() {
        List<OrdemDeCompraRecord> ordens = new ArrayList<>();

        OrdemDeCompraRecord ordem1 = new OrdemDeCompraRecord();
        ordem1.adicionarProduto(new ProdutoRecord("Produto 1", BigDecimal.valueOf(100.00)));
        ordem1.adicionarProduto(new ProdutoRecord("Produto 2", BigDecimal.valueOf(50.00)));

        OrdemDeCompraRecord ordem2 = new OrdemDeCompraRecord();
        ordem2.adicionarProduto(new ProdutoRecord("Produto A", BigDecimal.valueOf(30.00)));
        ordem2.adicionarProduto(new ProdutoRecord("Produto B", BigDecimal.valueOf(20.00)));

        ordens.add(ordem1);
        ordens.add(ordem2);

        return ordens;
    }

    public void salvarOrdemCompra() {
        System.out.println("Ordem de compra salva com sucesso!");
    }

    public void alterarOrdemDeCompra(int indice, ProdutoRecord novoProduto) {
        if (indice >= 0 && indice < produtos.size()) {
            produtos.set(indice, novoProduto);
            System.out.println("Produto na posição " + indice + " alterado para: " + novoProduto);
        } else {
            System.out.println("Índice inválido. Não foi possível alterar o produto.");
        }
    }

    public ProdutoRecord buscarProdutoPorNome(String nome) {
        for (ProdutoRecord produto : produtos) {
            if (produto.nome().equalsIgnoreCase(nome)) { // Acesso ao campo 'nome' diretamente
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
        for (ProdutoRecord produto : produtos) {
            System.out.println(produto);
        }
        System.out.println("Total: " + calcularTotal());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrdemDeCompra{\n");
        for (ProdutoRecord produto : produtos) {
            sb.append("  ").append(produto).append("\n");
        }
        sb.append("  Total=").append(calcularTotal()).append("\n");
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        OrdemDeCompraRecord ordem = new OrdemDeCompraRecord();

        ordem.adicionarProduto(new ProdutoRecord("Produto A", BigDecimal.valueOf(30.00)));
        ordem.adicionarProduto(new ProdutoRecord("Produto B", BigDecimal.valueOf(20.00)));

        System.out.println("Antes da alteração:");
        ordem.imprimirOrdemDeCompra();

        ordem.alterarOrdemDeCompra(1, new ProdutoRecord("Produto C", BigDecimal.valueOf(25.00)));

        System.out.println("\nDepois da alteração:");
        ordem.imprimirOrdemDeCompra();

        String nomeBusca = "Produto C";
        ProdutoRecord produtoEncontrado = ordem.buscarProdutoPorNome(nomeBusca);
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
        List<OrdemDeCompraRecord> ordens = ordem.buscarOrdensDeCompra();
        for (int i = 0; i < ordens.size(); i++) {
            System.out.println("\nOrdem de Compra " + (i + 1) + ":");
            ordens.get(i).imprimirOrdemDeCompra();
        }
    }
}
