package br.com.dio.samudev.java.io.IOBytes.IOObject;

import java.io.*;

@SuppressWarnings("all")
public class ExemploIOObject {

    public static void serializacao() {
        Gato gato = new Gato("Simba", 6, "amarelado", true, false);

        File f = new File("gato");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f.getName()));
             PrintStream ps = new PrintStream(System.out)
        ) {
            oos.writeObject(gato);
            ps.printf("Arquivo \"%s\" criado com sucesso! Tamanho '%d' bytes.", f.getName(), f.length());
        } catch (FileNotFoundException e) {

            System.out.printf("Arquivo %s não encontrado! Verifique o diretório %s", f.getName(), e.getMessage());

        } catch (IOException e) {

            System.out.printf("Não foi possível criar o arquivo \"%s\".", f.getName());
            e.printStackTrace();
        }
    }

    public static void desserializacao(String arquivo) {

        File f = new File(arquivo);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {

            Gato objetoGato = (Gato) ois.readObject();

            System.out.printf("\nNome..................: %s\n", objetoGato.getNome());
            System.out.printf("Idade............: %d\n", objetoGato.getIdade());
            System.out.printf("Cor...............: %s\n", objetoGato.getCor());
            System.out.printf("Castrado...............: %s\n", objetoGato.isCastrado());
            System.out.printf("Ronrona...............: %s\n", objetoGato.isRonrona());
        } catch (FileNotFoundException e) {
            System.out.printf("Arquivo %s não encontrado! Verifique o diretório %s", f.getName(), e.getMessage());

        } catch (ClassNotFoundException e) {
            System.out.printf("Não foi possível ler o objeto do arquivo \"%s\".", f.getName());

        } catch (IOException e) { //captura exigida pelo ObjectInputStream
            System.out.printf("Não foi possível abrir o arquivo \"%s\".", f.getName());

        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializacao();
        desserializacao("gato");
    }
}
