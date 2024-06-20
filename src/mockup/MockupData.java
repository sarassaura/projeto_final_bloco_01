package mockup;

import stock.controller.Controller;

public class MockupData {
	Controller products;
	
	public MockupData(Controller products) {
		this.products = products;
	}
	
	public void initialize() {
		ConsumerProducts cc1 = new ConsumerProducts(products.generateID(), 123, 1, "João Silva", 1000f, 100.0f);
		products.signup(cc1);

		ConsumerProducts cc2 = new ConsumerProducts(products.generateID(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		products.signup(cc2);

		IndustrialProducts cp1 = new IndustrialProducts(products.generateID(), 125, 2, "Mariana dos Santos", 4000f, 12);
		products.signup(cp1);

		IndustrialProducts cp2 = new IndustrialProducts(products.generateID(), 125, 2, "Juliana Ramos", 8000f, 15);
		products.signup(cp2);
	}

}
