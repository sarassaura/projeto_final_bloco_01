package stock.repository;

import stock.model.Product;

public interface Repository {
	// CRUD da Conta
	public void searchByNumber(String id);

	public void showAll();

	public String signup(Product account);

	public void update(Product account);

	public void delete(String id);
}
