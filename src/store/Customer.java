package store;
import java.util.ArrayList;

public class Customer {
    private String _name;
    private int _age;
    private ArrayList<Rental> _rentals;
    private ArrayList<Sale> _sales;
    
    public Customer (String name, int age) {
        _name = name;
        _age = age;
        _sales = new ArrayList<Sale>();
        _rentals = new ArrayList<Rental>();
    }
    
    public void addRental(Rental rental) {
        _rentals.add(rental);
    }
    
    public void addSale(Sale sale){
    	_sales.add(sale);
    }
    
    public String getName() {
        return _name;
    }
    
    public int getAge(){
    	return _age;
    }
    
    public ArrayList<Rental> getRentals(){
    	return _rentals;
    }
    
    public ArrayList<Sale> getSales(){
    	return _sales;
    }
    
}