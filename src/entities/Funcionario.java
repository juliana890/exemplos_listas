package entities;

public class Funcionario {
	
	private Integer id;
	private String name;
	private Double salary;
	
	public Funcionario() {}
	
	
	public Funcionario(Integer id, String name, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public void aumentoSalario(double porcentagem) {
		 salary += salary * porcentagem / 100;	
	}
	
	public String toString() {
		return id + ", " + name + ", " + salary;
	}
	
}
