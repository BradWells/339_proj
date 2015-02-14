package store;
public class NewMovieRental extends MovieRental{

	public NewMovieRental(String title, PriceCode code, int daysRented) {
		super(title, code, daysRented);
	}

	@Override
	public int getFrequentRenterPoints() {
       	int points = 1;
        // add bonus for a two day new release rental
        if (getDaysRented() > 1) {
                points=2;
        }
        return points;
	}

	@Override
	public double getPrice() {
		int price = getDaysRented() * 3;
		return price;
	}

}
