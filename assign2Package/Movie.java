package assign2Package;

import java.text.DecimalFormat;

/**
 * Movie is class that extends product. Stores and displays Movie information.
 * @author Dylan Wagner
 * @author Ethan Stewart
 * 
 */
public class Movie extends Product {
	
	private int upc;
	/**
	 * Default Constructor
	 */
	
	Movie() {}
	/**
	 * Constructor for the super variables sku, title, price, quantity
	 * @param-1- sku- user entered sku of movie
	 * @param-2- title- user entered title of movie
	 * @param-3- price- user entered price of movie
	 * @param-4- quantity- user entered quantity of movie
	 */
	
	Movie(int sku, String title, float price, int quantity) {
		super(sku, title, price, quantity);
	}
	/**
	 * Constructor to store sku, title, price, quantity, and upc
	 * @param-1- sku- user entered sku of movie
	 * @param-2- title- user entered title of movie
	 * @param-3- price- user entered price of movie
	 * @param-4- quantity- user entered quantity of movie
	 * @param-5- upc- user entered upc for movie object
	 */	
	Movie (int sku, String title, float price, int quantity, int upc) {
		this(sku, title, price, quantity);
		this.upc = upc;
	}
	/**
	 * Displays movie sku, title, price, quantity, and upc
	 */	
	public void display()
	{
		super.display();
		System.out.println("UPC: " + upc);
		System.out.println();
	}
	
	/**
	 * Displays object type using polymorphism
	 */	
	public void displayType(){
		System.out.print("Movie\t");
	}
	/**
	 * Calculates shipping credit, commission 
	 * @param-1- p- product object we are manipulating
	 * @param-2- userQuan- user entered quantity sold of a movie product
	 * @param-3- userShipping- user entered shipping costs of a movie product
	 * @return- returns total profit for sale as double
	 */	
	public double processSale(Product p, int userQuan, float userShipping){
		DecimalFormat priceFormat = new DecimalFormat("$##0.00");
		double price = super.processSale(p, userQuan, userShipping);
		System.out.println("Total Shipping Credit: \t" + 
						  priceFormat.format(2.98 * userQuan));
		System.out.println("Total Commission: \t" + 
						  priceFormat.format(price *.12));
		return ((price + (2.98*userQuan))-(.12* price + userShipping));
		
	}
}