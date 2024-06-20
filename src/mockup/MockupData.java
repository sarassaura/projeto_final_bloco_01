package mockup;

import stock.controller.Controller;
import stock.model.ConsumerProducts;
import stock.model.IndustrialProducts;

public class MockupData {
	Controller products;
	
	public MockupData(Controller products) {
		this.products = products;
	}
	
	public void initialize() {
		ConsumerProducts cc1 = new ConsumerProducts(products.generateID(), "Jiowl", 2000, 20, 10.0f, "Shoes",
				"Nike", "João da Silva");
		products.signup(cc1);

		ConsumerProducts cc2 = new ConsumerProducts(products.generateID(), "Bananana", 1000, 10, 100.0f, "Food","The Good Food", "Maria da Silva");
		products.signup(cc2);

		IndustrialProducts cp1 = new IndustrialProducts(products.generateID(), "SmartPen", 1000, 10, 100.0f, "office","Google", "Google");
		products.signup(cp1);

		IndustrialProducts cp2 = new IndustrialProducts(products.generateID(), "SlowPen", 1000, 10, 100.0f, "office","Safari", "Safari");
		products.signup(cp2);
	}

}
