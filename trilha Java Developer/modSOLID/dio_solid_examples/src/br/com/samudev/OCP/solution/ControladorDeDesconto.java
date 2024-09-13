package br.com.samudev.OCP.solution;

// A classe vai chamar o método da interface sem necessidade de qualquer tipo de alteração no código, ou seja, foi incluído uma funcionalidade nova sem mudar nada aqui.

public class ControladorDeDesconto {

    public void adicionarDescontoLivro(DescontoLivro descontoLivro) {
        descontoLivro.valorDesconto();
    }
}
