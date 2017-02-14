package assign2Package;
/**
 * Driver Class that contains a menu for the user to manipulate an
 * inventory ArrayList of products.
 * @author Dylan Wagner
 * @author Ethan Stewart
 *
 */
public class InventoryDriver {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		
		UserMenu menu = new UserMenu(); //UserMenu object to run and handle 
										//the user menu
		int userChoice;  //numeric value for user's input to hand do-while loop
		
		do {
			userChoice = menu.getNumericMenuOption();
			menu.handleUserChoice();
		} while (userChoice != 7);
				
	}
}

