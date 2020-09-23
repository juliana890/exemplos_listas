package entities;

public class Produto {
	
	private String name;
	private Double price;
	private Integer quantity;
	private Integer codigo;
	
	public Produto(String name, Double price, Integer quantity, Integer codigo) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.codigo = codigo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void alteraPreco(double newPrice) {
		price = newPrice;
	}
	
	public String toString() {
		return "Name: " + name + ", "
			 + "Price: " + String.format("%.2f", price) + ", "
			 + "Quantity: " + quantity + ", "
			 + "Code: " + codigo; 
	}

}
