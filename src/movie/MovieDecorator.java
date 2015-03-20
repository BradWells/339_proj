package movie;

import java.util.ArrayList;

import movie.Movie.Category;

public abstract class MovieDecorator extends Movie{
	private Movie _movie;

	public MovieDecorator(Movie movie) {
		super(movie.getTitle());
		_movie = movie;
	}
	
	public ArrayList<Category> getCategories() {
        return _movie.getCategories();
    }
    
    public void addCategory(Category newCategory) {
        _movie.addCategory(newCategory);
    }
    
    public void removeCategory(Category noCategory) {
        _movie.removeCategory(noCategory);
    }
	
	public int getId(){
		return _movie.getId();
	}

}
