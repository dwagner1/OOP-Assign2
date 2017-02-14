package assign2Package;

import java.text.DecimalFormat;

/**
 * Toy is class that extends product. Stores and displays Toy information. 
 * @author Dylan Wagner
 * @author Ethan Stewart
 * 
 */

public class Toy extends Product {

	private int weight;
	
	/**
	 * Default Constructor
	 */
	Toy() {}
	
	/**
	 * Constructor for the super variables sku, title, price, quantity
	 * @param-1- sku- user entered sku of toy
	 * @param-2- title- user entered title of toy
	 * @param-3- price- user entered price of toy
	 * @param-4- quantity- user entered quantity of toy
	 */
	Toy(int sku, String title, float price, int quantity) {
		super(sku, title, price, quantity);
	}
	
	/**
	 * Constructor for the super variables sku, title, price, quantity
	 * @param-1- sku- user entered sku of product
	 * @param-2- title- user entered title of toy
	 * @param-3- price- user entered price of toy
	 * @param-4- quantity- user entered quantity of toy
	 * @param-5- weight- user entered weight of toy in ounces
	 */
	Toy(int sku, String title, float price, int quantity, int weight) {
		this(sku, title, price, quantity);
		this.weight = weight;
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
	
	/**
	 * Displays object type using polymorphism
	 */	
	public void displayType(){
		System.out.print("Toy\t");
	}
	
	/**
	 * Calculates shipping credit, commission 
	 * @param-1- p- product object we are manipulating
	 * @param-2- userQuan- user entered quantity sold of product
	 * @param-3- userShipping- user entered shipping costs of product
	 * @return- returns total profit for sale as double
	 */	
	public double processSale(Product p, int userQuan, float userShipping){
		DecimalFormat priceFormat = new DecimalFormat("$##0.00");
		int weightToPounds = (weight + 16 -1)/16;//converts to pounds
		double price = super.processSale(p, userQuan, userShipping);
		System.out.println("Total Shipping Credit: \t" + 
					priceFormat.format((4.49 +(.5*weightToPounds))*userQuan));
		System.out.println("Total Commission: \t" + 
					priceFormat.format(price *.15));
		return ((price + (4.49 +(.5*weightToPounds))*userQuan)-
					(.15* price + userShipping));
		
	}
}
