package assign2Package;
import java.util.Scanner;
/**
 * UserMenu is a class that deals with the menu manipulation and user input
 * @author Dylan Wagner
 * @author Ethan Stewart
 * 
 */
public class UserMenu {
	
	UserMenu() {}
	
	private int userChoice; //numeric value for user input to handle menu 
							//and do-while
	private char productCat; //char value for product category case 1 of switch
	private Scanner input = new Scanner(System.in);//scanner
	private Inventory products = new Inventory();//instance of products
	
	float shipping;//stores numeric value for shipping costs
	int valid;//flag for validation loop
	int sku;   //numeric value for SKU input
	String title;  //String value for title input
	float price; //float value for price of product input
	int quantity; //numeric value for quantity of product input
	int upc; //numeric value for Movie UPC input
	int isbn; //numeric value for Book ISBN input
	String author; //String value for Book author input
	int weight; //numeric value for Toy weight input
	
	
	/**
	 * Gets input from user for menu choice. Validates number is correct
	 * @return Returns user number as int
	 */
	
	public int getNumericMenuOption() {
		
		valid = 0;
		do{
		System.out.println("\nOnline Store Inventory Menu\n");
		System.out.println("1. Add product ");
		System.out.println("2. Remove product ");
		System.out.println("3. Find product by sku ");
		System.out.println("4. Display inventory sorted by sku ");
		System.out.println("5. Display inventory sorted by title ");
		System.out.println("6. Process a sale ");
		System.out.println("7. Quit the program ");
		
		System.out.println("\nEnter your choice:");
		if(input.hasNextInt()){
			userChoice = input.nextInt();
			if(userChoice <1 || userChoice > 8){
				System.out.println("Please enter a number from 1-8");
				valid = 0;
			}
			if(userChoice >=1 && userChoice < 8)
				valid = 1;
			
		}
		else{
			System.out.println("Please enter a number from 1-8");
			valid = 0;
			input.next();
			
		}
		
		}while(valid!=1);
	
		return userChoice;//= input.nextInt();
	}
	
	/**
	 * Chooses correct menu option based on user input
	 */
	
	
	public void handleUserChoice() {
		switch (this.userChoice)
		{
			case 1:
				System.out.println("Enter the product type.");
				System.out.println("Enter M for Movie, B for Book, or T for Toy: ");
				
				productCat = Character.toUpperCase(input.next().charAt(0));
				
				if (productCat == 'M')
					this.addMovie();
				else if (productCat == 'B')
					this.addBook();
				else if (productCat == 'T')
					this.addToy();
				else
					System.out.println("Invalid category.");
				
				break;
			
			case 2:
				System.out.println("Enter the SKU for the movie "
					+ "to be removed: ");
				sku = input.nextInt();
				products.remove(sku);
				break;
				
			case 3:
				System.out.println("Enter the SKU of product to find: ");
				sku = input.nextInt();
				products.displayInfo(sku);
				break;
			
			case 4:
				products.displayBySku();
				break;
			
			case 5:
				products.displayByTitle();
				break;
				
			case 6: 
				System.out.println("Enter the SKU of sold items: ");
				sku = input.nextInt();
				System.out.println("Enter the quantity of sold items: ");
				quantity = input.nextInt();
				System.out.println("Enter the cost of shipping: ");
				shipping = input.nextFloat();
				products.findProduct(sku,quantity,shipping);
				
			case 7:
				products.save();
				break;
				
			default:
				System.out.println("Invalid menu option.");
		}
	}
	
	/**
	 * Gets input for sku, title, price, quantity, upc to add a movie object
	 */
	
	private void addMovie() {
		input.nextLine();
		System.out.println("Enter the SKU: ");
		sku = input.nextInt();
		input.nextLine();
		System.out.println("Enter the title: ");
		title = input.nextLine();
		System.out.println("Enter the price: ");
		price = input.nextFloat();
		System.out.println("Enter the quantity: ");
		quantity = input.nextInt();
		System.out.println("Enter the UPC: ");
		upc = input.nextInt();
		
		products.add(new Movie(sku, title, price, 
			quantity, upc));
	}
	
	/**
	 * Gets input for sku, title, price, quantity, author to add a book object
	 */
	private void addBook() {
		input.nextLine();
		System.out.println("Enter the SKU: ");
		sku = input.nextInt();	
		input.nextLine();
		System.out.println("Enter the title: ");
		title = input.nextLine();
		System.out.println("Enter the price: ");
		price = input.nextFloat();
		System.out.println("Enter the quantity: ");
		quantity = input.nextInt();
		System.out.println("Enter the ISBN: ");
		isbn = input.nextInt();
		System.out.println("Enter the author: ");
		input.nextLine();
		author = input.nextLine();
		
		products.add(new Book(sku, title, price, 
			quantity, isbn, author));
	}
	
	/**
	 * Gets input for sku, title, price, quantity, weight to add a toy object
	 */
	private void addToy() {
		input.nextLine();
		System.out.println("Enter the SKU: ");
		sku = input.nextInt();	
		input.nextLine();
		System.out.println("Enter the title: ");
		title = input.nextLine();
		System.out.println("Enter the price: ");
		price = input.nextFloat();
		System.out.println("Enter the quantity: ");
		quantity = input.nextInt();
		System.out.println("Enter the weight in ounces: ");
		weight = input.nextInt();	
		
		products.add(new Toy(sku, title, price, 
			quantity, weight));
	}
}
