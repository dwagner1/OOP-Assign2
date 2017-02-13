package assign2Package;
import java.util.*;
/**
 * ProductBySku is a class that deals with the product ordering by sku
 * @author Dylan Wagner
 * @author Ethan Stewart
 * 
 */

public class ProductBySku implements Comparator<Product>{
	
	public int compare(Product lhs, Product rhs){
		int lhsSku = lhs.getSku();
		int rhsSku = rhs.getSku();	
		if(lhsSku < rhsSku) return -1;
		if(lhsSku == rhsSku) return 0; 
		return 1;
	}

}