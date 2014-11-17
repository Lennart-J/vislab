package vislab.controller.action;

import com.opensymphony.xwork2.ActionSupport;

import vislab.model.bl.CategoryManager;
import vislab.model.db.Category;

public class EditCategoryAction extends ActionSupport {
	private static final long serialVersionUID = -983183915002226000L;

	private String name = null;

	public String create() throws Exception {

		CategoryManager categoryManager = new CategoryManager();

		Category category = categoryManager.getCategoryByPrimaryKey(getName());

		if (category == null) {
			category = new Category();

			category.setName(getName());

			categoryManager.saveCategory(category);

			return SUCCESS;
		} else {
			addActionError("Kategorie bereits vorhanden!");
			return "input";
		}

	}

	public String delete() throws Exception {

		CategoryManager categoryManager = new CategoryManager();
		Category category = categoryManager.getCategoryByPrimaryKey(getName());

		if (category != null) {
			categoryManager.deleteCategory(category);
			return SUCCESS;
		} else {
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
}
