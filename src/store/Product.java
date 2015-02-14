package store;

public abstract class Product {
	private static int _id = 0;
	
	public abstract String getTitle();
	public abstract double getRentalPrice(int daysRented);
	public abstract double getSellingPrice();
	public abstract void addCategory(String categoryName);
	public abstract int getId();
	
	public static int getNewId(){
		_id++;
		return _id;
	}
	
}
