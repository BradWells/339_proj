package book;

import java.util.ArrayList;
import store.Product;

public abstract class Book extends Product{
	
	private String _title;
	private ArrayList<Category> _categories;
	
	Book(String title){
		_categories = new ArrayList<Category>();
		_title = title;
	}
	
    public ArrayList<Category> getCategories() {
        return _categories;
    }
    
    public void addCategory(Category newCategory) {
        _categories.add(newCategory);
    }
    
    public void removeCategory(Category noCategory) {
        _categories.remove(noCategory);
    }
    
    public String getTitle() {
        return _title;
    }
    
    public enum Category {
    	CHILDRENS, HARDCOVER;
    }

}
