package vislab.controller.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import vislab.model.bl.ProductManager;
import vislab.model.bl.CategoryManager;
import vislab.model.db.Product;
import vislab.model.db.Category;

public class EditProductAction extends ActionSupport {
	private static final long serialVersionUID = -983183915002226000L;

	private String name = null;
	private String description = null;
	private int available = 0;
	private String image = null;
	private double price = 0.00;
	private Category category = null;
	List<Category> categories; //darf nicht null sein da dropdown?!
	
	
	public String create() throws Exception {

		ProductManager productManager = new ProductManager();
		CategoryManager categorymanager = new CategoryManager();

		Product product = productManager.getProductByPrimaryKey(getName());

		if (product == null) {
			product = new Product();

			product.setName(getName());
			product.setDescription(getDescription());
			product.setAvailable(getAvailable());
			product.setImage(getImage());
			product.setPrice(getPrice());
			product.setCategory(getCategory());

			productManager.saveProduct(product);
			addActionMessage("Sie haben das Produkt " + getName() + " angelegt.");
			return SUCCESS;
			
		} else {
			addActionError("Produkt bereits vorhanden!");
			return "input";
		}

	}

	public String delete() throws Exception {

		ProductManager productManager = new ProductManager();
		Product product = productManager.getProductByPrimaryKey(getName());

		if (product != null) {
			String name = getName();
			productManager.deleteProduct(product);
			addActionMessage("Sie haben das Produkt " + name + " gelöscht.");
			return SUCCESS;
		} else {
			addActionError("Produkt nicht vorhanden!");
			return "input";
		}
	}
	
	public void SelectAction() {
		CategoryManager categorymanager = new CategoryManager();
		categories = categorymanager.getAllCategories();
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
