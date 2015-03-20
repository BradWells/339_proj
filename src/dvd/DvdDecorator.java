package dvd;

import java.util.ArrayList;

public abstract class DvdDecorator extends Dvd{
	private Dvd _dvd;

	public DvdDecorator(Dvd dvd) {
		super(dvd.getTitle());
		_dvd = dvd;
	}
	
	public ArrayList<Category> getCategories() {
        return _dvd.getCategories();
    }
    
    public void addCategory(Category newCategory) {
        _dvd.addCategory(newCategory);
    }
    
    public void removeCategory(Category noCategory) {
        _dvd.removeCategory(noCategory);
    }
	
	public int getId(){
		return _dvd.getId();
	}

}
