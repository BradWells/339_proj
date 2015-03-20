package video_game;

import java.util.ArrayList;

public abstract class VideoGameDecorator extends VideoGame{
	private VideoGame _videoGame;

	public VideoGameDecorator(VideoGame videoGame) {
		super(videoGame.getTitle());
		_videoGame = videoGame;
	}
	
	public ArrayList<Category> getCategories() {
        return _videoGame.getCategories();
    }
    
    public void addCategory(Category newCategory) {
        _videoGame.addCategory(newCategory);
    }
    
    public void removeCategory(Category noCategory) {
        _videoGame.removeCategory(noCategory);
    }
	
	public int getId(){
		return _videoGame.getId();
	}

}
