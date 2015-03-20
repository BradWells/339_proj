package video_game;

public class WiiVideoGame extends VideoGameDecorator{

	public WiiVideoGame(VideoGame videoGame) {
		super(videoGame);
		addCategory(VideoGame.Category.WII);
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
