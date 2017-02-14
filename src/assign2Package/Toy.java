package assign2Package;
/**
 * Toy is class that extends product. Stores and displays Toy information. 
 * @author Dylan Wagner
 * @author Ethan Stewart
 * 
 */

public class Toy extends Product {

	private int weight;
	
	Toy() {}
	/**
	 * Constructor for the super variables sku, title, price, quantity
	 */	
	Toy(int sku, String title, float price, int quantity) {
		super(sku, title, price, quantity);
		System.out.println("executed super variables");
	}
	/**
	 * Constructor to store sku, title, price, quantity, and weight
	 */	
	Toy(int sku, String title, float price, int quantity, int weight) {
		this(sku, title, price, quantity);
		this.weight = weight;
		System.out.println("executed local toy variables");
	}
	/**
	 * Displays toy sku, title, price, quantity, and weight
	 */		
	public void display()
	{
		super.display();
		System.out.println("Weight: " + weight);
		System.out.println();
	}
	public void displayType(){
		System.out.print("Toy\t");
	}
}