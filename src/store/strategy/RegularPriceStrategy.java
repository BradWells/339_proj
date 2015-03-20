package store.strategy;

import java.util.ArrayList;

import store.Rental;
import store.Sale;

public class RegularPriceStrategy implements PriceStrategy{
	private ArrayList<Rental> _rentals;
	private ArrayList<Sale> _sales;
	
	public RegularPriceStrategy(ArrayList<Rental> rentals, ArrayList<Sale> sales){
		_rentals = rentals;
		_sales = sales;
	}
	
	@Override
	public double calculateTotalPrice() {
		double total = 0;
        for(Rental rental : _rentals){
            total += rental.getPrice();
        }
        
        for(Sale sale : _sales){
        	total+= sale.getPrice();
        }
        return total;
	}
}
