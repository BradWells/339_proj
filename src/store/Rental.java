package store;


public class Rental {
	Product _prod;
	int _days;
	
	public Rental(Product prod, int daysRented){
		_prod = prod;
		_days = daysRented;
	}
	public int getDaysRented(){
		return _days;
	}
    public int getFrequentRenterPoints(){
    	return _prod.getRentalPoints(_days);
    }
    public double getPrice(){
    	return _prod.getRentalPrice(_days);
    }
    public Product getProduct(){
    	return _prod;
    }
    
}
