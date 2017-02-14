package assign2Package;
import java.util.*;
/**
 * ProductBySku is a class that deals with the product ordering by sku
 * @author Dylan Wagner
 * @author Ethan Stewart
 * 
 */

public class ProductBySku implements Comparator<Product>{
	
	/**
	 * Compares two sku's and orders them alphabetically
	 * @param-1- lhs- stores product object1
	 * @param-2- rhs- stores product object2
	 * @return Returns a number based on the position the sku should be in
	 */	
	public int compare(Product lhs, Product rhs){
		int lhsSku = lhs.getSku();//stores sku on left hand side
		int rhsSku = rhs.getSku();	//stores second sku on right
		if(lhsSku < rhsSku) return -1;
		if(lhsSku == rhsSku) return 0; 
		return 1;
	}

}
