package stock.controller;

import java.util.ArrayList;
import java.util.UUID;

import stock.model.Product;
import stock.repository.Repository;
import stock.util.Format;

public class Controller implements Repository {

	private ArrayList<Product> productList = new ArrayList<Product>();

	@Override
	public void searchByNumber(String id) {
		var product = searchInCollection(id);

		if (product != null)
			product.showProduct();
		else
			Format.text("The Product ID : " + id + " was not found!", 1, 1, false);
	}

	@Override
	public void showAll() {
		for (var account : productList) {
			account.showProduct();
		}

	}

	@Override
	public String signup(Product account) {
		productList.add(account);
		return account.getId();
	}

	@Override
	public void update(Product account) {
		var searchProduct = searchInCollection(account.getId());

		if (searchProduct != null) {
			productList.set(productList.indexOf(searchProduct), account);
			Format.text("The Product Id: " + account.getId() + " was successfully updated!", 1, 1, false);
		} else
			Format.text("The Product Id: " + account.getId() + " was not found!", 1, 1, false);

	}

	@Override
	public void delete(String id) {
		var product = searchInCollection(id);

		if (product != null) {
			if (productList.remove(product) == true)
				Format.text("The Product Id: " + id + " was successfully deleted!", 1, 1, false);
		} else
			Format.text("The Product Id: " + id + " was not found!", 1, 1, false);

	}
	
	public String generateID() {
		return UUID.randomUUID().toString();
	}
	
	public Product searchInCollection(String id) {
		for (var product : productList) {
			if (id.equals(product.getId())) {
				return product;
			}
		}

		return null;
	}

}
