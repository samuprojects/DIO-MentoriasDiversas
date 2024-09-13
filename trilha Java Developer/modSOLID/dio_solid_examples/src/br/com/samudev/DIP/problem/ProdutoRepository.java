package br.com.samudev.DIP.problem;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    private MySqlConnection mySqlConnection;

    public ProdutoRepository(MySqlConnection mySqlConnection) {
        this.mySqlConnection = mySqlConnection;
    }

    public List<Produto> buscarProdutos() {
        return new ArrayList<>();
    }

    public void salvarProduto(Produto produto) {
        // salvar lista de produtos na base de dados
    }
}
