package store;
import java.util.ArrayList;


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
		//TODO should this be moved?
		ArrayList<Rental> rentals        = _customer.getRentals();
		int points = 0;
        for(Rental rental : rentals){
            points += rental.getFrequentRenterPoints();
        }
        return points;
	}

	private double calculateTotalPrice() {
		//TODO should this be moved?
		
		double total = 0;
        for(Rental rental : _customer.getRentals()){
            total += rental.getPrice();
        }
        
        for(Sale sale : _customer.getSales()){
        	total+= sale.getPrice();
        }
        return total;
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
