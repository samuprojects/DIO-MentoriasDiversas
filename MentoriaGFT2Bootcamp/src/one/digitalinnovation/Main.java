package one.digitalinnovation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import one.digitalinnovation.dominio.Bootcamp;
import one.digitalinnovation.dominio.Conteudo;
import one.digitalinnovation.dominio.Curso;
import one.digitalinnovation.dominio.Dev;
import one.digitalinnovation.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {

		Curso cursoJavaBasico = new Curso();
		cursoJavaBasico.setTitulo("Java Básico");
		cursoJavaBasico.setDescricao("Aprenda os conceitos básicos sobre Java");
		cursoJavaBasico.setCargaHoraria(8);

		Curso cursoDotNet = new Curso();
		cursoDotNet.setTitulo("DOT Net");
		cursoDotNet.setDescricao("Aprenda os conceitos básicos sobre Dot Net");
		cursoDotNet.setCargaHoraria(8);

		Curso cursoJavaAvancado = new Curso();
		cursoJavaAvancado.setTitulo("Java Avançado");
		cursoJavaAvancado.setDescricao("Aprenda os conceitos avançados sobre Java");
		cursoJavaAvancado.setCargaHoraria(8);

		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Aprendendo Orientação a Objetos com Java");
		mentoria.setDescricao("Imersão sobre os pilares da Orientação a Objetos");
		mentoria.setData(LocalDateTime.now());

		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("GFT START #2 Java");
		bootcamp.setInicio(LocalDate.now());
		bootcamp.setFim(bootcamp.getInicio().plusDays(45));
		List<Conteudo> conteudosBootcamp = Arrays.asList(cursoJavaBasico, cursoJavaAvancado, mentoria);
		bootcamp.setConteudos(conteudosBootcamp);

		Dev pedrao = new Dev();
		pedrao.setNome("Pedrão");

		Dev joao = new Dev();
		joao.setNome("João");

		pedrao.inscrever(cursoDotNet);
		pedrao.inscrever(bootcamp);
		pedrao.progredir();
		pedrao.progredir();

		joao.inscrever(bootcamp);
		joao.progredir();
		joao.progredir();
		joao.progredir();
		joao.progredir();

		System.out.printf("XP Felipão: %.2f \n", pedrao.calcularTotalXp());
		System.out.printf("XP João: %.2f \n", joao.calcularTotalXp());

		List<Dev> ranking = Arrays.asList(pedrao, joao).stream()
				.sorted((dev1, dev2) -> Double.compare(dev2.calcularTotalXp(), dev1.calcularTotalXp()))
				.collect(Collectors.toList());

		for (Dev dev : ranking) {
			System.out.println(dev.getNome());
		}

	}

}
