package vislab.model.db;

// Generated 13.03.2008 13:06:16 by Hibernate Tools 3.2.0.CR1

/**
 * Customer generated by hbm2java
 */
public class Product implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private double price;
	private int available;
	private String image;
	private String category;

	public Product() {
	}

	public Product(String name, String description, double price, int available,
			String image, String category) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.available = available;
		this.image = image;
		this.category = category;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
