package stock.model;

import stock.Menu;
import stock.util.Colors;
import stock.util.Format;

public class Product extends Menu {

	private String id;
	private String name;
	private int totalSales;
	private int availableProducts;
	private float price;
	private String category;
	private String brand;
	private int type;

	public Product(String id, String name, int totalSales, int availableProducts, float price, String category,
			String brand) {
		this.id = id;
		this.totalSales = totalSales;
		this.availableProducts = availableProducts;
		this.price = price;
		this.category = category;
		this.brand = brand;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	public int getAvailableProducts() {
		return availableProducts;
	}

	public void setAvailableProducts(int availableProducts) {
		this.availableProducts = availableProducts;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void showProduct() {

		System.out.print(Colors.TEXT_RED + Colors.ANSI_BLACK_BACKGROUND);
		Format.stars("");
		System.out.print(Colors.TEXT_WHITE);
		Format.text("Products's Data:", 0, 1, true);
		System.out.print(Colors.TEXT_RED);
		Format.stars("");
		System.out.print(Colors.TEXT_WHITE);
		Format.text("Products's ID: " + this.id, 0, 1, false);
		Format.text("Products's Name: " + this.id, 0, 1, false);
		Format.text("Total Sales: " + this.totalSales, 0, 1, false);
		Format.text("Available: " + this.availableProducts, 0, 1, false);
		Format.text("Price: " + this.price, 0, 1, false);
		Format.text("Category: " + this.category, 0, 1, false);
		Format.text("Brand: " + this.brand, 0, 1, false);
	}

}
