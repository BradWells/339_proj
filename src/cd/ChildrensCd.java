package cd;

public class ChildrensCd extends CdDecorator{

	public ChildrensCd(Cd cd) {
		super(cd);
		addCategory(Cd.Category.CHILDRENS);
	}

	@Override
	public int getRentalPoints(int daysRented) {
		return 1;
	}

	@Override
	public double getRentalPrice(int daysRented) {
        double price = 1.5;
        if (daysRented > 3) {
            price += (daysRented - 3) * 1.5;
        }
        return price;
	}

	@Override
	public double getSellingPrice() {
		return 3;
	}

}
