package store.strategy;

import java.util.ArrayList;

import store.Rental;
import store.Sale;

public class PercentOffSalesStrategy implements PriceStrategy{
	private ArrayList<Rental> _rentals;
	private ArrayList<Sale> _sales;
	private double _factor;
	
	public PercentOffSalesStrategy(ArrayList<Rental> rentals, ArrayList<Sale> sales, double percent){
		_rentals = rentals;
		_sales = sales;
		_factor = percent/100;
	}
	
	@Override
	public double calculateTotalPrice() {
		double total = 0;
        for(Rental rental : _rentals){
            total += rental.getPrice();
        }
        
        for(Sale sale : _sales){
        	total+= sale.getPrice() * _factor;
        }
        return total;
	}
}
