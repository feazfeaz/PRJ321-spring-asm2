package bean;

public class ProductModel extends Model {

	String nameItems;
	int price;
	String description;

	public ProductModel() {

	}

	public ProductModel(int id, String nameItems, int price, String description) {
		this.id = id;
		this.nameItems = nameItems;
		this.price = price;
		this.description = description;
	}
	

	public String getNameItems() {
		return nameItems;
	}

	public void setNameItems(String nameItems) {
		this.nameItems = nameItems;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
