package vislab.controller.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import vislab.model.bl.ProductManager;
import vislab.model.db.Product;

public class SearchProductAction extends ActionSupport {
	private static final long serialVersionUID = -983183915002226000L;

	private Product product;
	private List<Product> productList;

	private String minPrice = null;
	private String maxPrice = null;
	private String name = null;
	private String description = null;
	private String category = null;

	public String search() throws Exception {

		ProductManager productManager = new ProductManager();

		this.productList = productManager.searchProduct(getName(), getDescription(), getCategory(), getMinPrice(), getMaxPrice());

		if (productList == null || productList.isEmpty()) {
			addActionMessage("Keine Suchergebnisse gefunden!");
			return "input";
		} else {
			return SUCCESS;
		}

	}

	@Override
	public void validate() {
		super.validate();
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
