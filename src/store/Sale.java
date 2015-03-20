package store;

public class Sale {
	Product _prod;
	
	public Sale(Product prod){
		_prod = prod;
	}
    public double getPrice(){
    	return _prod.getSellingPrice();
    }
    public Product getProduct(){
    	return _prod;
    }
}
