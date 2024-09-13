package br.com.samudev.DIP.solution;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    private DbConnection dbConnection;

    public ProdutoRepository(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public List<Produto> buscarProdutos() {
        return new ArrayList<>();
    }

    public void salvarProduto(Produto produto) {
        // salvar lista de produtos na base de dados
    }
}