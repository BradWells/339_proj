package store;
import java.util.ArrayList;

public class Customer {
    private String _name;
    private ArrayList<Rental> _rentals = new ArrayList<Rental>();
    
    public Customer (String name) {
        _name = name;
    }
    
    public void addRental(Rental rental) {
        _rentals.add(rental);
    }
    
    public String getName() {
        return _name;
    }
    
    public ArrayList<Rental> getRentals(){
    	return _rentals;
    }
    
}