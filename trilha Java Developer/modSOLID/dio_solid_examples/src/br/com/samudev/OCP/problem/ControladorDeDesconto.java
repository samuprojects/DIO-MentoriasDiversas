package br.com.samudev.OCP.problem;

public class ControladorDeDesconto {

    public void adicionarDescontoLivroInfantil(DescontoLivroInfantil descontoLivroInfantil) {
        descontoLivroInfantil.valorDescontoLivroInfantil();
    }

    public void adicionarDescontoLivroAutoAjuda(DescontoLivroAutoAjuda descontoLivroAutoAjuda) {
        descontoLivroAutoAjuda.valorDescontoLivroAutoAjuda();
    }

    // criado posteriormente quebrando o princípio O.C.P
    public void adicionarDescontoLivroAcao(DescontoLivroAcao descontoLivroAcao){
        descontoLivroAcao.descontoLivroAcao();
    }
}
