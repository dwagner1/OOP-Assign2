package assign2Package;

import java.text.DecimalFormat;

/**
 * Book is class that extends product. Stores and displays book information. 
 * @author Dylan Wagner
 * @author Ethan Stewart
 * 
 */
public class Book extends Product {

	private int isbn;
	private String author;
	/**
	 * Default Constructor
	 */
	Book() {}
	/**
	 * Constructor for the super variables sku, title, price, quantity
	 * @param-1- sku- user entered sku of book
	 * @param-2- title- user entered title of book
	 * @param-3- price- user entered price of book
	 * @param-4- quantity- user entered quantity of book
	 */
	Book(int sku, String title, float price, int quantity) {
		super(sku, title, price, quantity);
	}
	/**
	 * Constructor for the super variables sku, title, price, quantity
	 * @param-1- sku- user entered sku of book
	 * @param-2- title- user entered title of book
	 * @param-3- price- user entered price of book
	 * @param-4- quantity- user entered quantity of book
	 * @param-5- isbn- user entered number for isbn of book
	 * @param-6- author- user entered author of book
	 */
	Book(int sku, String title, float price, int quantity, 
			int isbn, String author) {
		this(sku, title, price, quantity);
		this.isbn = isbn;
		this.author = author;
	}
	/**
	 * Displays book sku, title, price, quantity, and author 
	 */	
	public void display()
	{
		super.display();
		System.out.println("Author: " + author);
		System.out.println("ISBN: " + isbn);
		System.out.println();
	}
	/**
	 * Displays object type using polymorphism
	 */	
	public void displayType(){
		System.out.print("Book\t");
	}
	/**
	 * Calculates shipping credit, commission 
	 * @param-1- p- product object we are manipulating
	 * @param-2- userQuan- user entered quantity sold of product
	 * @param-3- userShopping- user entered shipping costs of product
	 * @return- returns total profit for sale as double
	 */	
	public double processSale(Product p, int userQuan, float userShipping){
		DecimalFormat priceFormat = new DecimalFormat("$##0.00");//format float
		double price = super.processSale(p, userQuan, userShipping);//stores
																//total price 
		
		System.out.println("Total Shipping Credit: \t" + 
				priceFormat.format(3.99 * userQuan));
		System.out.println("Total Commission: \t" + 
				priceFormat.format(price *.15));
		return ((price + (3.99*userQuan))-(.15* price + userShipping));
		
	}

}
