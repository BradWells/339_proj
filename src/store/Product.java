package store;

import java.util.ArrayList;

public abstract class Product {
	private static int _id = 0;
	
	public abstract String getTitle();
	public abstract double getRentalPrice(int daysRented);
	public abstract int getRentalPoints(int daysRented);
	public abstract double getSellingPrice();
	public abstract int getId();
	//Will have to cast
	public abstract ArrayList getCategories();
	
	public static int getNewId(){
		_id++;
		return _id;
	}
	
}
