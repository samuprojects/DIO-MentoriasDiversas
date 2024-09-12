package br.com.dio.samudev.java.io.IOCharacter;

import java.io.*;
import java.util.Scanner;

public class Exercicio2IOCaracter { //Abrir teclado para escrever 3 filmes e salvar em "recomendacoes.txt"

    public static void lerTecladoEscreverDocumento() throws IOException {

        //utilizado o PrintWriter para didática com IO, poderia utilizar o System.out sem problemas
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Digite 3 filmes que você recomendaria: ");
        pw.flush();

        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        File f = new File("recomendacoes.txt");

        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName()));

        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = scan.nextLine();
        } while (!(line.equalsIgnoreCase("fim"))); // "fim" não é impresso porque é a flag que sinaliza o encerramento da aplicação

        pw.printf("Arquivo \"%s\" foi criado com sucesso!", f.getName());

        pw.close();
        scan.close();
        bw.close();
    }


    public static void main(String[] args) throws IOException {
        lerTecladoEscreverDocumento();
    }

}
