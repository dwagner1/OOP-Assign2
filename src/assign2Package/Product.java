package assign2Package;
import java.text.*;
import java.io.*;
/**
 * A Product is an object that contains information about that product.
 * Such as product sku, title, price, quantity of that product. Also contains
 * specific variables for each product. move-upc, book-author,isbn toy-weight
 * @author Dylan Wagner
 * @author Ethan Stewart
 *
 */
public class Product implements Comparable<Product>, Serializable{

	private int sku;//numeric value for the sku
	private String title;//string value for the product title
	private float price;//float value for the product price
	private int quantity;//numeric value for quantity of some product
	private DecimalFormat priceFormat = new DecimalFormat("$##0.00");//formats
	//the float to 2 decimal places.
	
	/**
	 * Default Constructor
	 */
	Product() {}
	
	/**
	 * Constructor for the super variables sku, title, price, quantity
	 * @param-1- sku- user entered sku of product
	 * @param-2- title- user entered title of product
	 * @param-3- quantity- user entered quantity of product
	 */
	Product(int sku, String title, float price, int quantity) {
		this.sku = sku;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}

	/**
	 * Formatting for sorting by title
	 */		
	public int compareTo(Product rhs){
		return title.compareTo(rhs.title);
	}
	
	/**
	 * display Type of object used for polymorphism
	 */	
	public void displayType(){
	}
	
	/**
	 * Format for displaying a single product
	 */
	public void display() {
		System.out.println("Title: " + title);
		System.out.println("SKU: " + sku);
		System.out.println("Price: " + priceFormat.format(price));
		System.out.println("Quantity: " + quantity);		
	}

	/**
	 * Format for displaying the table of products
	 */
	public void displaytable(){
		System.out.println(sku + "\t" + quantity + "\t" + 
	    priceFormat.format(price)+ "\t" + title);
	}
	
	/**
	 * Getter for the sku
	 * @return Returns the sku number as int
	 */
	public int getSku() {
		return this.sku;
	}
	
	/**
	 * Getter for the quantity
	 * @return Returns the quantity number as int
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 * Getter for the title of the Product
	 * @return Returns the title as string
	 */	
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Calculates and updates quantity of a product 
	 * @param-1- p- product object we are manipulating
	 * @param-2- userQuan- user entered quantity sold of product
	 * @param-3- userShipping- user entered shipping costs of product
	 * @return- returns total price as double
	 */	
	public double processSale(Product p, int userQuan, float userShipping){
		DecimalFormat priceFormat = new DecimalFormat("$##0.00");
		p.quantity -= userQuan;
		System.out.println("Total Price: \t\t" + 
				priceFormat.format(p.price * userQuan));
		return userQuan * p.price;
	}

}
