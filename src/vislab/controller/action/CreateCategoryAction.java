package vislab.controller.action;


import com.opensymphony.xwork2.ActionSupport;

import vislab.model.bl.CategoryManager;
import vislab.model.db.Category;

public class CreateCategoryAction extends ActionSupport {
	private static final long serialVersionUID = -983183915002226000L;

	private String name = null;
	private int id = 0;

	
	
	
	public String create() throws Exception {
		
	   	CategoryManager categoryManager = new CategoryManager();
	   	
		Category category = categoryManager.getCategoryByPrimaryKey(getId());
		
		System.out.println("create");
		if (category == null || !(categoryManager.isCategoryInTable(getName())) ) {
			category = new Category();

			category.setName(getName());

			categoryManager.saveCategory(category) ;
			
			return SUCCESS;
	   	}
	   	else {
			addActionError("Kategorie bereits vorhanden!");
			return "input";
	   	}
		

	}
	
public String delete() throws Exception {
		
	   	CategoryManager categoryManager = new CategoryManager();
		Category category = categoryManager.getCategoryByPrimaryKey(getId());
	    
		if (category != null && categoryManager.isCategoryInTable(getName()) ) {
			categoryManager.deleteCategory(category) ;
			return SUCCESS;
	   	}
	   	else {
			addActionError("Kategorie nicht vorhanden!");
			return "input";
	   	}
	}



	@Override
    public void validate() {
    	super.validate();
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




}
