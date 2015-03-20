package store;
import java.util.ArrayList;

import store.strategy.DoublePointStrategy;
import store.strategy.PercentOffPriceStrategy;
import store.strategy.PointStrategy;
import store.strategy.PriceStrategy;
import store.strategy.RegularPointStrategy;
import store.strategy.RegularPriceStrategy;
import movie.Movie;


public class Statement {
	
	private Customer _customer;
	private double _totalPrice;
	private int _totalPoints;

    public Statement(Customer customer) {
    	_customer = customer;
    	_totalPrice = calculateTotalPrice();
    	_totalPoints = calculateTotalPoints();
	}

	private int calculateTotalPoints() {
		PointStrategy strategy;
		boolean hasNewRelease = false;
		for(Rental r : _customer.getRentals()){
			r.getProduct().getCategories().contains(Movie.Category.NEW_RELEASE);
		}
		if(hasNewRelease 
				&& _customer.getAge() >= 18
				&& _customer.getAge() <= 22){
			strategy = new DoublePointStrategy(_customer.getRentals());
		}
		else if(TODO){
			strategy = new DoublePointStrategy(_customer.getRentals());
		}
		else{
			strategy = new RegularPointStrategy(_customer.getRentals());
		}
		return strategy.calculateTotalPoints();
	}

	private double calculateTotalPrice() {
		PriceStrategy strategy;
		int numRentals = _customer.getRentals().size();
		if(numRentals>5){
			strategy = new PercentOffPriceStrategy(_customer.getRentals(), _customer.getSales(), 50);
		}
		else if(numRentals>3){
			strategy = new PercentOffPriceStrategy(_customer.getRentals(), _customer.getSales(), 80);
		}
		else{
			strategy = new RegularPriceStrategy(_customer.getRentals(), _customer.getSales());
		}
		return strategy.calculateTotalPrice();
	}

	public String getReceipt() {
		//TODO clean this up, possibly move more code around.
        String result = "Rental Record for " + _customer.getName() + "\n";
        
        for(Rental rental : _customer.getRentals()){
            // show figures for this rental
            result += "\t" + rental.getProduct().getTitle() +
                      "\t" + String.valueOf(rental.getPrice()) + "\n";
        }
        
        result += "Sales Record for " + _customer.getName() + "\n";
        
        for(Sale sale : _customer.getSales()){
        	// show figures for this rental
            result += "\t" + sale.getProduct().getTitle() +
                      "\t" + String.valueOf(sale.getPrice()) + "\n";
        }
        
        // add footer lines
        result += "Amount owed is " + String.valueOf(_totalPrice) + "\n";
        result += "You earned " + String.valueOf(_totalPoints) +
                  " frequent renter points";
        return result;
    }
	
	public String getHTML() {
		//TODO clean this up, possibly move more code around.

		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>");
		
        sb.append("<body>");
        
        //Rentals
        
        sb.append("Rental Record for ").append(_customer.getName()).append("<br>");
        
        sb.append("<table>");
        
        for(Rental rental : _customer.getRentals()){
        	sb.append("<tr>");
            // show figures for this rental
            sb.append("<td>").append(rental.getProduct().getTitle()).append("</td>");
            sb.append("<td>").append(String.valueOf(rental.getPrice())).append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        
        //Sales
        
        sb.append("Sales Record for ").append(_customer.getName()).append("<br>");
        
        sb.append("<table>");
        
        for(Sale sale : _customer.getSales()){
        	sb.append("<tr>");
            // show figures for this rental
            sb.append("<td>").append(sale.getProduct().getTitle()).append("</td>");
            sb.append("<td>").append(String.valueOf(sale.getPrice())).append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        
        // add footer lines
        sb.append("Amount owed is ").append(String.valueOf(_totalPrice)).append("<br>");
        sb.append("You earned ").append(String.valueOf(_totalPoints)).append(" frequent renter points").append("<br>");
        
        sb.append("</html>");
        return sb.toString();
    }
	
	public Customer getCustomer(){
		return _customer;
	}
	
	public double getTotalPrice(){
		return _totalPrice;
	}
	
	public double getTotalPoints(){
		return _totalPoints;
	}
    
}
