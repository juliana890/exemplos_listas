package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;

public class Program_Produto {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Produto> myList = new ArrayList<>();
		Produto produto;
		
		System.out.print("Quantos produtos deseja cadastrar? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++){
			sc.nextLine();
			System.out.println("\nProduct #" + (i+1) + ":");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			System.out.print("Code: ");
			Integer code = sc.nextInt();
			//Valida��o de c�digo de produto
			while(hasProduct(myList, code)) {
				System.out.print("This product taken! Try again: ");
				code = sc.nextInt();
			}
			produto = new Produto(name, price, quantity, code);
			myList.add(produto);
		}
		
		sc.nextLine();
		System.out.print("\nDeseja alterar o pre�o de algum produto? (s/n): ");
		char resp = sc.nextLine().charAt(0);
		
		if(resp == 's') {
			System.out.print("Entre com o c�digo do produto para altera��o de pre�o: ");
			Integer code = sc.nextInt();
			Integer pos = position(myList, code);
			
			if(pos == null) {
				System.out.println("This product does not exist!");
			}else {
				System.out.print("\nDigite o novo pre�o do produto: ");
				Double newPrice = sc.nextDouble();
				myList.get(pos).alteraPreco(newPrice);
			}
		}
		
		System.out.println("\nList of Products:");
		for(Produto p : myList) {
			System.out.println(p);
		}
		
		sc.close();

	}
	
	//Fun��o que valida se j� existe o produto cadastrado
	public static boolean hasProduct(List<Produto> myList, int code) {
		Produto prod = myList.stream().filter(p -> p.getCodigo() == code).findFirst().orElse(null); //Buscamos c�digo na lista de produtos
		return prod != null; //Se cont�m retorna prod
	}
	
	//Fun��o que retorna a posi��o do produto na lista
	public static Integer position(List<Produto> myList, int code) {
		for(int i = 0; i < myList.size(); i++){
			if(myList.get(i).getCodigo() == code){
				return i;
			}
		}
		
		return null;
	}

}
