package br.com.samudev.OCP.solution;

public class DescontoLivroInfantil implements DescontoLivro {

    @Override
    public double valorDesconto() {
        return 0.3;
    }
}
