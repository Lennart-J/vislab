package vislab.controller.action;

import com.opensymphony.xwork2.ActionSupport;

import vislab.model.bl.ProductManager;
import vislab.model.bl.CategoryManager;
import vislab.model.db.Product;

public class EditProductAction extends ActionSupport {
	private static final long serialVersionUID = -983183915002226000L;

	private String name = null;
	private String description = null;
	private int available = 0;
	private String image = null;
	private double price = 0.00;
	
	
	public String create() throws Exception {

		ProductManager productManager = new ProductManager();
		CategoryManager categorymanager = new CategoryManager();

		Product product = productManager.getProductByPrimaryKey(getName());

		if (product == null) {
			product = new Product();
			int i = 0;

			product.setName(getName());
			product.setDescription(getDescription());
			product.setAvailable(getAvailable());
			product.setImage(getImage());
			product.setPrice(getPrice());
			product.setCategory(categorymanager.getCategoryByPrimaryKey("Schwarz"));

			productManager.saveProduct(product);

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
			productManager.deleteProduct(product);
			return SUCCESS;
		} else {
			addActionError("Produkt nicht vorhanden!");
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
}
