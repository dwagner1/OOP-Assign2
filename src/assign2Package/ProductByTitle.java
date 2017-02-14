package assign2Package;
import java.util.*;
/**
 * ProductByTitle is a class that deals with the product ordering by title
 * @author Dylan Wagner
 * @author Ethan Stewart
 * 
 */
public class ProductByTitle implements Comparator<Product>{
	
	public int compare(Product lhs, Product rhs){
		return lhs.getTitle().compareTo(rhs.getTitle());
	}

}