package br.com.dio.samudev.java.io.IOCharacter;

import java.io.*;

public class Exercicio1IOCaracter { //Abrir teclado para escrever 3 filmes e exibir no console

    public static void receberTecladoImprimirConsole() throws IOException {

        // no código comentado há um exemplo não muito utilizado, a seguir utilizado um padrão de projeto Decorator
        System.out.println("Recomende 3 filmes: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while (!(line.isEmpty())); // vai encerrar quando der ENTER na linha em branco
        bw.flush(); // para descarregar e depois fechar o fluxo com o close (boa prática).

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        receberTecladoImprimirConsole();
    }
}
