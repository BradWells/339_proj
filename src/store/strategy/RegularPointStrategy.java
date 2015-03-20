package store.strategy;

import java.util.ArrayList;

import store.Rental;

public class RegularPointStrategy implements PointStrategy{
	private ArrayList<Rental> _rentals;
	
	public RegularPointStrategy(ArrayList<Rental> rentals){
		_rentals = rentals;
	}

	@Override
	public int calculateTotalPoints() {
		int points = 0;
        for(Rental rental : _rentals){
            points += rental.getFrequentRenterPoints();
        }
        return points;
	}

}
