package br.com.samudev.LSP.solution;

// Umas das possíveis soluções sugeridas pelo professor: Separar Quadrado e Retângulo utilizando uma implementação de interface.
// O intuito é tratar as classes de forma polimórfica e cada uma calcula a área de acordo com sua própria lógica.

// Interface para cálculo de área
public interface FormaOpcao1 {
    double getArea();
}

class Retangulo implements FormaOpcao1 {
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

class Quadrado implements FormaOpcao1 {
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

class Main {
    public static void main(String[] args) {
        FormaOpcao1 forma;

        forma = new Retangulo();
        ((Retangulo) forma).setAltura(10);
        ((Retangulo) forma).setLargura(5);
        System.out.println("Área do Retângulo: " + forma.getArea());

        forma = new Quadrado();
        ((Quadrado) forma).setLado(5);
        System.out.println("Área do Quadrado: " + forma.getArea());
    }
}
