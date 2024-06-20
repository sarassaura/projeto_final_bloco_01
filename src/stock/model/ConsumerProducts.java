package stock.model;

import stock.util.Format;

public class ConsumerProducts extends Product {

	private String client;

	public ConsumerProducts(String id, String name, int totalSales, int availableProducts, float price, String category,
			String brand, String client) {
		super(id, name, totalSales, availableProducts, price, category, brand, 0);
		this.client = client;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	@Override
	public void showProduct() {
		super.showProduct();
		Format.text("Client's name: " + this.client, 0, 2, false);
	}

}