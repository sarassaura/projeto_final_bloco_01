package stock.model;

import stock.util.Format;

public class IndustrialProducts extends Product {

	private String enterprise;

	public IndustrialProducts(String id, String name, int totalSales, int availableProducts, float price,
			String category, String brand, String enterprise) {
		super(id, name, totalSales, availableProducts, price, category, brand);
		this.enterprise = enterprise;
	}

	public String getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	@Override
	public void showProduct() {
		super.showProduct();
		Format.text("Enterprise's name: " + this.enterprise, 0, 2, false);
	}

}