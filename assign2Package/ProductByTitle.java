package assign2Package;
import java.util.*;
/**
 * ProductByTitle is a class that deals with the product ordering by title
 * @author Dylan Wagner
 * @author Ethan Stewart
 * 
 */
public class ProductByTitle implements Comparator<Product>{
	/**
	 * Compares two titles and orders them alphabetically
	 * @param-1- lhs- stores product object1
	 * @param-2- rhs- stores product object2
	 * @return Returns title in order
	 */	
	public int compare(Product lhs, Product rhs){
		return lhs.getTitle().toLowerCase().compareTo
				(rhs.getTitle().toLowerCase());
	}

}
