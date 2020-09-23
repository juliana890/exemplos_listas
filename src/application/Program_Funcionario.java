package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Funcionario;  //Correção do exercício: https://youtu.be/Xj-osdBe3TE

public class Program_Funcionario {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		List<Funcionario> myList = new ArrayList<>();
		Funcionario funcionario;
		
		for(int i = 0; i < n; i++) {
			System.out.println("\nEmplyoee #" + (i + 1) + ":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			while(hasId(myList, id)) {
				System.out.print("ID already taken. Try again: ");
				id = sc.nextInt();
			}
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
		    funcionario = new Funcionario(id, name, salary);
			myList.add(funcionario);
		
		}
		
		System.out.print("\nEnter the employee ID that will have salary increase : ");
		int idI = sc.nextInt();
		
		Funcionario fun = myList.stream().filter(f -> f.getId() == idI).findFirst().orElse(null);
		if(fun == null) {
			System.out.println("This ID does not exist!");
		}else {
			System.out.print("Enter the percentage: ");
			double porcentagem = sc.nextDouble();
			fun.aumentoSalario(porcentagem);
			
		}
		
		/* Outra maneira de efetuar a busca dentro da lista
		Integer pos = position(myList, idI);
		if(pos == null) {
			System.out.println("This ID does not exist!");
		}else {
			System.out.print("Enter the percentage: ");
			double porcentagem = sc.nextDouble();
			myList.get(pos).aumentoSalario(porcentagem);
			
		} */
			
		System.out.println("\nList of employees:");
		for(Funcionario f : myList) {
			System.out.println(f);
		}	
		
		
		sc.close();

	}
	
	public static Integer position(List<Funcionario> myList, int id) {
		for(int i = 0; i < myList.size(); i++) {
			if(myList.get(i).getId() == id) {
				return i;
			
			}
		}
		return -1;
	}
	
	public static boolean hasId(List<Funcionario> myList, int id) {
		Funcionario fun = myList.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
		return fun != null;
	}
	
}
