package br.com.samudev.SRP.solution;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        OrdemDeCompra ordem = new OrdemDeCompra();
        ordem.adicionarProduto(new Produto("Produto A", BigDecimal.valueOf(30.00)));
        ordem.adicionarProduto(new Produto("Produto B", BigDecimal.valueOf(20.00)));

        OrdemDeCompraRepository repository = new OrdemDeCompraRepository();
        repository.salvarOrdemCompra(ordem);

        OrdemDeCompraPrint printService = new OrdemDeCompraPrint();
        printService.imprimirOrdemDeCompra(ordem);

        OrdemDeCompraMail mailService = new OrdemDeCompraMail();
        mailService.enviarEmail(ordem, "cliente@example.com");

        System.out.println("\nBuscando ordens de compra:");
        List<OrdemDeCompra> ordens = repository.buscarOrdensDeCompra();
        for (int i = 0; i < ordens.size(); i++) {
            System.out.println("\nOrdem de Compra " + (i + 1) + ":");
            printService.imprimirOrdemDeCompra(ordens.get(i));
        }
    }
}