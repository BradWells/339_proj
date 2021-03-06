package book;

public class SimpleBook extends Book{
	
	private int _id;
	
	public SimpleBook(String title) {
		super(title);
		_id = getNewId();
	}

	@Override
	public double getRentalPrice(int daysRented) {
		double price = 2;
        if (daysRented > 2) {
            price += (daysRented - 2) * 1.5;
        }
        return price;
	}

	@Override
	public int getRentalPoints(int daysRented) {
		return 1;
	}

	@Override
	public double getSellingPrice() {
		return 8;
	}
	
	@Override
	public int getId(){
		return _id;
	}
}
