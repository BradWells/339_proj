package store;

import java.util.ArrayList;

public abstract class Movie extends Product{
	
	private String _title;
	private ArrayList<Category> _categories;
	private int _id;
	
	Movie(String title){
		_title = title;
		_id = getNewId();
	}
	
	Movie(String title, ArrayList<Category> cats){
		_title = title;
		_categories = cats;
	}
	
    public ArrayList<Category> getCategory() {
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
    
    public int getId(){
    	return _id;
    }
    
	public static Category lookupCategory(String typeString){
		if(typeString == null)
			return null;
		
		Category returnCat = null;
		for(Category pc : Category.values()){
			if(typeString.equals(pc.toString())){
				returnCat = pc;
			}
		}
		return returnCat;
	}

	public enum Category {
		// help from http://stackoverflow.com/questions/3978654/java-string-enum
		CHILDRENS("child"),
		REGULAR("reg"), 
		NEW_RELEASE("new")
		;
		
		private final String _typeString;
		
		private Category(final String typeString) {
			_typeString = typeString;
		}
		
		@Override
	    public String toString() {
	        return _typeString;
		}
	}

}
