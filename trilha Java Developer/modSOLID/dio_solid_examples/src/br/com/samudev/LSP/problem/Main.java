package br.com.samudev.LSP.problem;

public class Main {

    public static void main(String[] args) {

        Retangulo retangulo = new Quadrado(); // por mais que um quadrado seja um retangulo ele modifica as propriedades do retangulo
        // existem várias soluções possíveis como extrair do método retangulo o getArea e colocar numa abstração de uma interface para calcular a área
        //onde cada retangulo ou quadrado calculasse a propria área
        // ou fazer um quadrado e não estender do retangulo
        // o importante é entender que nem toda abstração funciona, a não ser que seja feita com a classe base.

        retangulo.setAltura(10);
        retangulo.setLargura(5);

        System.out.println("Area: " + retangulo.getArea());
    }
}
