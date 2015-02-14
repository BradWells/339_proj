package store;

public abstract class MovieRental implements Rental{
    private int   _daysRented;
    
    public MovieRental(Movie movie, int daysRented) {
        _daysRented = daysRented;
    }

	public int getDaysRented() {
        return _daysRented;
    }
    
    public abstract int getFrequentRenterPoints();
    
    public abstract double getPrice();
    
}