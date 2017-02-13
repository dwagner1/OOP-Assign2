package assign2Package;
/**
 * Book is class that extends product. Stores and displays book information. 
 * @author Dylan Wagner
 * @author Ethan Stewart
 * 
 */
public class Book extends Product {

	private int isbn;
	private String author;
	
	Book() {}
	/**
	 * Constructor for the super variables sku, title, price, quantity
	 */	
	Book(int sku, String title, float price, int quantity) {
		super(sku, title, price, quantity);
	}
	/**
	 * Constructor book object to store sku, title, price, quantity, author
	 * and isbn
	 */	
	Book(int sku, String title, float price, int quantity, int isbn, String author) {
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
	public void displayType(){
		System.out.print("Book\t");
	}

}