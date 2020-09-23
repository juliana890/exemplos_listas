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
			//Validação de código de produto
			while(hasProduct(myList, code)) {
				System.out.print("This product taken! Try again: ");
				code = sc.nextInt();
			}
			produto = new Produto(name, price, quantity, code);
			myList.add(produto);
		}
		
		sc.nextLine();
		System.out.print("\nDeseja alterar o preço de algum produto? (s/n): ");
		char resp = sc.nextLine().charAt(0);
		
		if(resp == 's') {
			System.out.print("Entre com o código do produto para alteração de preço: ");
			Integer code = sc.nextInt();
			Integer pos = position(myList, code);
			
			if(pos == null) {
				System.out.println("This product does not exist!");
			}else {
				System.out.print("\nDigite o novo preço do produto: ");
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
	
	//Função que valida se já existe o produto cadastrado
	public static boolean hasProduct(List<Produto> myList, int code) {
		Produto prod = myList.stream().filter(p -> p.getCodigo() == code).findFirst().orElse(null); //Buscamos código na lista de produtos
		return prod != null; //Se contém retorna prod
	}
	
	//Função que retorna a posição do produto na lista
	public static Integer position(List<Produto> myList, int code) {
		for(int i = 0; i < myList.size(); i++){
			if(myList.get(i).getCodigo() == code){
				return i;
			}
		}
		
		return null;
	}

}
