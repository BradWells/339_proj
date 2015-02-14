package store;

public class RegularMovieRental extends MovieRental{
	
	public RegularMovieRental(String title, PriceCode code, int daysRented) {
		super(title, code, daysRented);
	}

	@Override
	public int getFrequentRenterPoints() {
		return 1;
	}

	@Override
	public double getPrice(){
        double price = 2;
        if (getDaysRented() > 2) {
            price += (getDaysRented() - 2) * 1.5;
        }
        return price;
	}
}
