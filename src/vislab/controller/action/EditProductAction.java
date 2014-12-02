package vislab.controller.action;


import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import vislab.model.bl.ProductManager;
import vislab.model.bl.CategoryManager;
import vislab.model.db.Category;
import vislab.model.db.Product;
import vislab.model.db.Category;

public class EditProductAction extends ActionSupport {
	private static final long serialVersionUID = -983183915002226000L;
	
	

	private String name = null;
	private String description = null;
	private int available = 0;
	private String image = null;
	private double price = 0.00;
	private String category = null;

	
	
	public String create() throws Exception {

		ProductManager productManager = new ProductManager();
		CategoryManager categoryManager = new CategoryManager();

		Product product = productManager.getProductByPrimaryKey(getName());

		if (product == null) {

			if(categoryManager.getCategoryByPrimaryKey(getCategory()) != null) {
				product = new Product();
				product.setName(getName());
				product.setDescription(getDescription());
				product.setAvailable(getAvailable());
				product.setImage(getImage());
				product.setPrice(getPrice());
				product.setCategory(new Category(getCategory()));
	
				productManager.saveProduct(product);
				addActionMessage("Sie haben das Produkt <" + getName() + "> erstellt.");
	
				return "create_success";
			} else {
				addActionError("Diese Kategorie existiert nicht. Bitte geben Sie eine gültige Kategorie ein!");
				return "create_input";
			}

		} else {
			addActionError("Produkt bereits vorhanden!");
			return "create_input";
		}

	}

	public String delete() throws Exception {

		ProductManager productManager = new ProductManager();
		Product product = productManager.getProductByPrimaryKey(getName());

		if (product != null) {
			String name = product.getName();
			productManager.deleteProduct(product);
			addActionMessage("Sie haben das Produkt <" + name + "> gelöscht.");
			return SUCCESS;
		} else {
			addActionError("Das zu löschende Produkt existiert nicht!");
			return "input";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public void validate() {
		if (name.length() > 30) {
			addFieldError("name", "Nachname nicht mehr als 30 Zeichen!");
		}
		if (description.length() > 500) {
			addFieldError("description", "Beschreibung nicht mehr als 500 Zeichen!");
		}
		if (price < 0) {
			addFieldError("price", "Negative Preise sind nicht gültig!");
		}
		if (available < 0) {
			addFieldError("available", "Negative Verfügbarkeitsmengen sind nicht gültig!");
		}
		super.validate();
	}
}
