package store;

import java.util.ArrayList;

public class ProductDatabase {
	private ArrayList<Product> prods = null;
	
	public void addProduct(Product product){
		prods.add(product);
	}
	
	
	public Product deleteProduct(int id){
		Product prod = getProduct(id);
		prods.remove(prod);
		return prod;
	}
	
	//TODO This searching is inefficient
	public Product getProduct(int id){
		for(Product prod : prods){
			if(prod.getId() == id){
				return prod;
			}
		}
		return null;
	}
	
	public static void generateProducts(){
		
	}
	
}
