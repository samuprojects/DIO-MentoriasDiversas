package br.com.samudev.SRP.solution;

import java.util.ArrayList;
import java.util.List;

public class OrdemDeCompraRepository {

    private final List<OrdemDeCompra> ordensDeCompra = new ArrayList<>();

    public void salvarOrdemCompra(OrdemDeCompra ordemDeCompra) {
        ordensDeCompra.add(ordemDeCompra);
        System.out.println("Ordem de compra salva com sucesso!");
    }

    public List<OrdemDeCompra> buscarOrdensDeCompra() {
        return new ArrayList<>(ordensDeCompra); // Retorna uma cópia da lista
    }

    public void alterarOrdemDeCompra(int index, OrdemDeCompra novaOrdemDeCompra) {
        if (index >= 0 && index < ordensDeCompra.size()) {
            ordensDeCompra.set(index, novaOrdemDeCompra);
            System.out.println("Ordem de compra na posição " + index + " alterada.");
        } else {
            System.out.println("Índice inválido. Não foi possível alterar a ordem de compra.");
        }
    }

    public void removerOrdemDeCompra(int index) {
        if (index >= 0 && index < ordensDeCompra.size()) {
            ordensDeCompra.remove(index);
            System.out.println("Ordem de compra removida com sucesso.");
        } else {
            System.out.println("Índice inválido. Não foi possível remover a ordem de compra.");
        }
    }
}