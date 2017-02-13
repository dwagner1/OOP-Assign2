package assign2Package;
/**
 * Movie is class that extends product. Stores and displays Movie information.
 * @author Dylan Wagner
 * @author Ethan Stewart
 * 
 */
public class Movie extends Product {
	
	private int upc;
	
	Movie() {}
	/**
	 * Constructor for the super variables sku, title, price, quantity
	 */	
	Movie(int sku, String title, float price, int quantity) {
		super(sku, title, price, quantity);
	}
	/**
	 * Constructor to store sku, title, price, quantity, and upc
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
	
	//public void updateQuantity(int userQuan){
//		Product(int userQUan)
//	}

	public void displayType(){
		System.out.print("Movie\t");
	}
}