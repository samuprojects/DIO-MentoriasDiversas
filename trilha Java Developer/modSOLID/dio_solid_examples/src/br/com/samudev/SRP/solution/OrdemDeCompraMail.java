package br.com.samudev.SRP.solution;

public class OrdemDeCompraMail {

    public void enviarEmail(OrdemDeCompra ordemDeCompra, String email) {
        System.out.println("E-mail enviado para: " + email);
        System.out.println("Detalhes da ordem de compra:\n" + ordemDeCompra);
    }
}