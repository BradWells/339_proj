package store;

public class ChildrensMovieRental extends MovieRental{

	public ChildrensMovieRental(String title, PriceCode code, int daysRented) {
		super(title, code, daysRented);
	}

	@Override
	public int getFrequentRenterPoints() {
		return 1;
	}

	@Override
	public double getPrice() {
        double price = 1.5;
        if (getDaysRented() > 3) {
            price += (getDaysRented() - 3) * 1.5;
        }
        return price;
	}

}
