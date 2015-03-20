package store.strategy;

import java.util.ArrayList;

import store.Rental;

public class DoublePointStrategy implements PointStrategy{
	private ArrayList<Rental> _rentals;
	
	public DoublePointStrategy(ArrayList<Rental> rentals){
		_rentals = rentals;
	}
	
	@Override
	public int calculateTotalPoints() {
		int points = 0;
        for(Rental rental : _rentals){
            points += rental.getFrequentRenterPoints();
        }
        points *= 2;
        return points;
	}

}
