package store;

import java.util.ArrayList;

import video_game.*;
import movie.*;
import book.*;
import cd.*;
import dvd.*;

public class ProductDatabase {
	private static ProductDatabase self = new ProductDatabase();
	private ArrayList<Product> _prods;
	
	private ProductDatabase(){
		_prods = new ArrayList<Product>();
	}
	
	public static ProductDatabase getDatabase(){
		return self;
	}
	
	public void addProduct(Product product){
		_prods.add(product);
	}
	
	
	public Product deleteProduct(int id){
		Product prod = getProduct(id);
		_prods.remove(prod);
		return prod;
	}
	
	//TODO This searching is inefficient
	public Product getProduct(int id){
		for(Product prod : _prods){
			if(prod.getId() == id){
				return prod;
			}
		}
		return null;
	}
	
	//Generates some mock products for testing purposes
	public void generateProducts(){
		addProduct(new SimpleMovie("A Movie"));
		addProduct(new NewMovie( new SimpleMovie("New Movie")));
		addProduct(new WiiVideoGame( new SimpleVideoGame("Wii Game")));
		addProduct(new HardCoverBook( new SimpleBook("Hardcover Book")));
		addProduct(new XboxVideoGame( new SimpleVideoGame("Xbox Game")));
		addProduct(new SimpleBook("A Simple Book"));
		addProduct(new NewMovie(new ChildrensMovie( new SimpleMovie("New Childrens Movie"))));
	}
	
}
