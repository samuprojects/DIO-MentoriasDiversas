package br.com.samudev.LSP.solution;

// Uma outra possível solução é utilizando classe abstrata para seguir a ideia de herança
// Assim Quadrado não estende Retangulo, mas ambos estendem uma classe base Forma.
// Isso pode evitar a necessidade de sobrescrever métodos e garantir que a substituição funcione corretamente.

// Classe base abstrata
public abstract class FormaOpcao2 {
    public abstract double getArea();
}

class RetanguloOpcao2 extends FormaOpcao2 {
    private double altura;
    private double largura;

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    @Override
    public double getArea() {
        return altura * largura;
    }
}

// Classe Quadrado, não mais derivada de Retangulo
class QuadradoOpcao2 extends FormaOpcao2 {
    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double getArea() {
        return lado * lado;
    }
}

class MainOpcao2 {
    public static void main(String[] args) {
        FormaOpcao2 forma;

        forma = new RetanguloOpcao2();
        ((RetanguloOpcao2) forma).setAltura(10);
        ((RetanguloOpcao2) forma).setLargura(5);
        System.out.println("Área do Retângulo: " + forma.getArea());

        forma = new QuadradoOpcao2();
        ((QuadradoOpcao2) forma).setLado(5);
        System.out.println("Área do Quadrado: " + forma.getArea());
    }
}
