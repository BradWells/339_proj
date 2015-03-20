package cd;

import java.util.ArrayList;

public abstract class CdDecorator extends Cd{
	private Cd _cd;

	public CdDecorator(Cd cd) {
		super(cd.getTitle());
		_cd = cd;
	}
	
	public ArrayList<Category> getCategories() {
        return _cd.getCategories();
    }
    
    public void addCategory(Category newCategory) {
        _cd.addCategory(newCategory);
    }
    
    public void removeCategory(Category noCategory) {
        _cd.removeCategory(noCategory);
    }
	
	public int getId(){
		return _cd.getId();
	}

}
