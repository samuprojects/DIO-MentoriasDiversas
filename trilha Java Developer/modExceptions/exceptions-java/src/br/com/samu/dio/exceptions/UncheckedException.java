package br.com.samu.dio.exceptions;

import javax.swing.*;

@SuppressWarnings("all")
public class UncheckedException {

    public static void main(String[] args) {

        boolean continueLooping = true;
        do {
            String a = JOptionPane.showInputDialog("Numerador: "); // JOptionPane retorna String
            String b = JOptionPane.showInputDialog("Denominador: ");

            try{
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b)); // Integer para receber a String e parseInt para converter em int
                System.out.println("Resultado: " + resultado);
                continueLooping = false;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Entrada inválida, informe um número inteiro! " + e.getMessage());

            } catch (ArithmeticException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Impossível dividir número por zero!");
            }  finally {
                System.out.println("Chegou no finally!");
            }
        } while (continueLooping);

        System.out.println("O código continua...");
    }

    public static int dividir(int a, int b) {
        return a / b;
    }
}
