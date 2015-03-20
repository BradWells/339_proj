package book;

import java.util.ArrayList;

public abstract class BookDecorator extends Book{
	private Book _book;

	public BookDecorator(Book book) {
		super(book.getTitle());
		_book = book;
	}
	
	public ArrayList<Category> getCategories() {
        return _book.getCategories();
    }
    
    public void addCategory(Category newCategory) {
        _book.addCategory(newCategory);
    }
    
    public void removeCategory(Category noCategory) {
        _book.removeCategory(noCategory);
    }
	
	public int getId(){
		return _book.getId();
	}

}
