package assign2Package;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
/**
 * Inventory is class that holds an array of products
 * @author Dylan Wagner
 * @author Ethan Stewart
 * 
 */
public class Inventory implements Serializable{
	
	public ArrayList<Product> inventory = new ArrayList<Product>();
	/**
	 * Creates an inventory array from a file. If no file exists then
	 * the array is empty
	 */
	public Inventory()
	{
		try {
            FileInputStream fis = new FileInputStream("InventoryFile");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Product> products =
                  (ArrayList<Product>)ois.readObject();  // explicit cast reqd
            fis.close();
            this.inventory = products;
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find datafile.");
        } catch (IOException e)  {
            System.out.println("Problem with file input.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found on input from file.");
        }
        
 
	}
	/**
	 * Adds a product to the array. Also checks for duplicates
	 * @param p The product to add
	 */
	public void add(Product p) {
		int index = -1; //numeric value that updates if sku is found,
			//index = -1 means index not found
		
		for (Product s : inventory) {
			if (s.getSku() == p.getSku()) {
				index = inventory.indexOf(s);
				break;
			}
		}
		if (index == -1)
			inventory.add(p);
		else
			System.out.println("A product with that SKU already exists.");
	}
	/**
	 * Removes product from the array if the sku exists
	 * @param sku The sku of the movie to be removed
	 */
	public void remove(int sku) {
		int index = -1;//numeric value that updates if sku is found, 
		//index = -1 means index not found
		
		for (Product p : inventory) {
			if (p.getSku() == sku) {
				index = inventory.indexOf(p);
				break;
			}
		}

		if (index == -1)
			System.out.println("No match found in the inventory, sorry.");
		else {
			inventory.remove(index);
			System.out.println("Product successfully removed from inventory.");
		}
	}
	/**
	 * Displays info for a specific product
	 * @param sku The sku to search for.
	 */
	public void displayInfo(int sku) {
		int found = 0;//numeric value that updates if sku is found
		for (Product p : inventory) {
			if (p.getSku()==sku){
				p.display();
				found = 1;
			}
			
		}	
		if(found == 0)
			System.out.println("SKU not found.");
	}
	/**
	 * Displays all of the products in order by SKU
	 */
	public void displayBySku() {		
		Comparator<Product> comp = new ProductBySku();
		Collections.sort(inventory, comp);
		for (Product p : inventory) {
			p.displayType();
			p.displaytable();
		}
				
	}

	/**
	 * Displays all of the products in order by Title
	 */	
	public void displayByTitle() {	
		Comparator<Product> comp = new ProductByTitle();
		Collections.sort(inventory, comp);
		for (Product p : inventory) {
			p.displayType();	
			p.displaytable();
		}
	}
		
	/**
	 * Saves the inventory array to a file so it can be reused.
	 */
	public void save()
	{
       try {
            FileOutputStream fos = new FileOutputStream("InventoryFile");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(inventory);
            fos.close();
     } catch (IOException e) {
            System.out.println("Problem with file output");
        }
		
	}
	/**
	 * Finds product in the arrayList and passes to product for calculations
	 * @param-1- sku- user entered sku
	 * @param-2- userQuantity- user entered quantity sold
	 * @param-3- userShip- user entered shipping costs
	 */
	public void findProduct(int sku, int userQuantity, float userShip){
		DecimalFormat priceFormat = new DecimalFormat("$##0.00");//format profit
		int found = 0;//numeric value that updates if sku is found
		double profit = 0;//numeric value to store total profit
		for (Product p : inventory) {
			if (p.getSku() == sku) {
				profit = p.processSale(p, userQuantity, userShip);
				found = 1;						
			}

		}
		if(found == 0)
			System.out.println("SKU not found.");
		System.out.println("Profit: \t\t" + priceFormat.format(profit));
	}	
	

}