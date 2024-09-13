package br.com.samudev.OCP.solution;

// foi criado posteriormente e não alterou nada a classe que controla o desconto

public class DescontoLivroAcao implements DescontoLivro {

    @Override
    public double valorDesconto() {
        return 0.2;
    }
}
