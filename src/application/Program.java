package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {

		/* Objetos do tipo List não é possível utilizar o tipo primitivo, somente o
		   wrapper class
		   Para instanciar o objeto List devemos utilizar uma classe especifica para
		   isso nesse caso utilizamos ArrayList */
		List<String> list = new ArrayList<>(); 

		list.add("Maria");
		list.add("Alex");
		list.add("Bob");
		list.add("Anna");

		// Para adicionar elementos em determinada posição da lista, passamos a posição conforme abaixo:
		list.add(2, "Marco");

		// For each para exibir os dados contidos na lista
		for (String x : list) {
			System.out.println("X: " + x);
		}

		// Para saber o tamanho da lista é utilizado o .size()
		System.out.println("\nTamanho: " + list.size());

		/*
		   Para remover elementos da lista é utilizado o .remove(), passamos a posição
		   ou o valor contido na lista list.remove(1); //Removendo o registro da
		   primeira posição list.remove("Anna"); //Removendo o registro que contém a
		   String Anna
		 
		   System.out.println();
		  
		   for(String x: list) { System.out.println("X: " + x); }
		 */

		/* Para remover elementos que comecem com alguma letra nesse caso vamos utilizar
		   a 'M'
		   Utilizamos o removeif, que é remoção por predicado
		   Remoção por predicado nós definimos uma função lambda, conforme abaixo */
		list.removeIf(x -> x.charAt(0) == 'M');

		System.out.println();

		for (String x : list) {
			System.out.println("List: " + x);
		}

		// Para encontrar o indice de algum elemento na lista utilizamos o indexOf, conforme abaixo:
		System.out.println("\nIndex Of Bob: " + list.indexOf("Bob"));
		System.out.println("Index Of Marco: " + list.indexOf("Marco")); // Quando não é encontrado o registro ele retorna -1

	   /* Para filtrar registros na lista é preciso criar uma nova lista
		  Pegamos a lista original list convertemos para stream(), acima do java 8 é
		  uma função que aceita expressões do tipo lambda
		  A partir do stream() nós chamamos o filter() que aceita predicado
		  A função stream() ela não é compatível com List então nós precisamos chamar o
		  collector (collect(Collectors.toList()) conforme abaixo:
		  Primeiro tornamos ele stream, fazemos a operação e depois tornamos ele em
		  lista novamente com o collector */
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());

		System.out.println();
		//Imprimindo somente os registros que comecem com a letra A
		for (String x : result) {
			System.out.println("Result: " + x);
		}
		
	   /* Para encontrar o primeiro elemento que comece com a letra A
		  Passamos o stream com o predicado no filter
		  Utilizamos o findFirst() para encontrar o primeiro resgitro
		  Utilizamos o orElse porque o findFirst é uma função verdadeiro ou falso, se ele não encontrar nada ele retorna nulo */
		String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
		System.out.println("\nName: " + name);
	
	}

}
