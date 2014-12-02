package vislab.controller.action;

import com.opensymphony.xwork2.ActionSupport;

import vislab.model.bl.CategoryManager;
import vislab.model.db.Category;
import vislab.model.bl.ProductManager;

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

			addActionMessage("Sie haben die Kategorie <" + getName() + "> angelegt.");

			return SUCCESS;
		} else {
			addActionError("Kategorie bereits vorhanden!");
			return "input";
		}

	}

	public String delete() throws Exception {

		CategoryManager categoryManager = new CategoryManager();
		Category category = categoryManager.getCategoryByPrimaryKey(getName());
		ProductManager productManager = new ProductManager();

		if (category != null) {

			if (!productManager.existProductWithCategory(category.getName())) {
				String name = category.getName();
				categoryManager.deleteCategory(category);
				addActionMessage("Sie haben die Kategorie <" + name + "> gelöscht.");
				return SUCCESS;
			} else {
				addActionError("Bitte löschen Sie zuerst die Produkte, die sich in der Kategorie befinden!");
				return "input";
			}

		} else {
			addActionError("Kategorie nicht vorhanden!");
			return "input";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void validate() {
		if (name.length() > 8) {
			addFieldError("name", "Name nicht mehr als 8 Zeichen!");
		}
		super.validate();
	}
}
