package br.com.samudev.SRP.solution;

public class OrdemDeCompraPrint {

    public void imprimirOrdemDeCompra(OrdemDeCompra ordemDeCompra) {
        System.out.println("Detalhes da Ordem de Compra:");
        for (Produto produto : ordemDeCompra.getProdutos()) {
            System.out.println(produto);
        }
        System.out.println("Total: " + ordemDeCompra.calcularTotal());
    }
}