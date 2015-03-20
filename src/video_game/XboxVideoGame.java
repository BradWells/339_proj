package video_game;

public class XboxVideoGame extends VideoGameDecorator{
	
	public XboxVideoGame(VideoGame videoGame) {
		super(videoGame);
		addCategory(VideoGame.Category.XBOX);
	}

	@Override
	public double getSellingPrice() {
		return 10;
	}

	@Override
	public double getRentalPrice(int daysRented) {
		int price = daysRented * 3;
		return price;
	}

	@Override
	public int getRentalPoints(int daysRented) {
       	int points = 1;
        // add bonus for a two day new release rental
        if (daysRented > 1) {
                points=2;
        }
        return points;
	}

}
