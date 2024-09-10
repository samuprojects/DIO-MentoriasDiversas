package br.com.samu.dio.exceptions;

import javax.swing.*;
import java.io.*;

@SuppressWarnings("all")
public class CheckedException {

    public static void main(String[] args) {
        String nomeDoArquivo = "romances-blake-crouch.txt";
        try {
            imprimirArquivoNoConsole(nomeDoArquivo);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Revise o nome do arquivo para impressão!  " +  "Causa: "+ e.getCause());
            e.printStackTrace();

        } catch (IOException e) { // como IOException é o maior nível não pode ficar no catch acima pois do contrário nunca cairia na FileNotFoundException
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado, entre em contato com o suporte!  " +  "Causa: "+ e.getCause());
            e.printStackTrace();

        } finally {
            System.out.println("Chegou no finally");
        }

        System.out.println("Apesar da exception ou não, o programa continua...");
    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException {
        File file = new File(nomeDoArquivo);

        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while (line != null);
        bw.flush();
        bw.close();
    }
}
