package one.digitalinnovation;

public class Main {
	
	public static void main(String[] args) { // outra estrutura de dados sem nenhum uso de vetor ou outra estrutura pronta
		
		Fila<String> minhaFila = new Fila<>();
		
		minhaFila.enqueue("primeiro");
		minhaFila.enqueue("segundo");
		minhaFila.enqueue("terceiro");
		minhaFila.enqueue("quarto");
		
		System.out.println(minhaFila);
		
		System.out.println(minhaFila.dequeue());
		
		System.out.println(minhaFila);
		
		minhaFila.enqueue("último");
		
		System.out.println(minhaFila);
		
		System.out.println(minhaFila.first());
		
		System.out.println(minhaFila);
		
		
	}

}
