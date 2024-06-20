package stock;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import mockup.MockupData;
import stock.controller.Controller;
import stock.model.ConsumerProducts;
import stock.model.IndustrialProducts;
import stock.util.Colors;
import stock.util.Format;

public abstract class Menu {
	public static void main(String[] args) {

		Controller products = new Controller();
		MockupData mockupData = new MockupData(products);
		mockupData.initialize();

		Scanner sc = new Scanner(System.in);

		int option = 0, availableProducts, totalSales, type;
		String category, brand, id, name, nameType;
		float price;

		do {
			Format.stars(Colors.TEXT_BLACK_BOLD + Colors.ANSI_CYAN_BACKGROUND);
			Format.text("", 0, 1, true);
			Format.text("PETBANK", 0, 1, true);
			Format.text("", 0, 1, true);
			Format.stars("");
			Format.text("", 0, 1, true);
			Format.text("1 - Create Product      ", 0, 1, true);
			Format.text("2 - Show all Products   ", 0, 1, true);
			Format.text("3 - Search Product by ID", 0, 1, true);
			Format.text("4 - Update Product      ", 0, 1, true);
			Format.text("5 - Delete Product      ", 0, 1, true);
			Format.text("6 - Exit                ", 0, 1, true);
			Format.text("", 0, 1, true);
			Format.stars("");
			Format.text("Choose an Operation by Number:", 0, 1, true);
			Format.text("", 0, 1, true);

			try {
				System.out.print(Colors.TEXT_RESET);
				option = sc.nextInt();
				System.out.print(Colors.ANSI_CYAN_BACKGROUND + Colors.TEXT_BLACK_BOLD);
			} catch (InputMismatchException e) {
				System.out.print(Colors.TEXT_YELLOW + Colors.ANSI_BLACK_BACKGROUND);
				Format.text("Enter Integer Values!", 1, 1, true);
				sc.nextLine();
				option = 0;
			}

			switch (option) {
			case 1:
				Format.title("Create Product");

				System.out.print(Colors.TEXT_RESET);

				System.out.print("Enter the Product's Name: ");
				name = sc.nextLine();
				sc.nextLine();
				System.out.print("Enter the Product's Price: ");
				price = sc.nextFloat();
				System.out.print("Enter the Available Amount: ");
				availableProducts = sc.nextInt();
				System.out.print("Enter the Product's category: ");
				sc.skip("\\R?");
				category = sc.nextLine();
				System.out.print("Enter the Product's Brand: ");
				brand = sc.nextLine();

				do {
					System.out.print("Enter the type of Product (1-Consumer ou 2-Industrial): ");
					type = sc.nextInt();
				} while (type < 1 || type > 2);

				switch (type) {
				case 1 -> {
					sc.skip("\\R?");
					System.out.print("Enter the Client Name: ");
					name = sc.nextLine();
					String productNumber = products.signup(new ConsumerProducts(products.generateID(), name, 0,
							availableProducts, price, category, brand, name));
					System.out.println("\nThe Product Id: " + productNumber + " was successfully created!");
				}
				case 2 -> {
					System.out.print("Enter the Enterprise Name: ");
					name = sc.nextLine();
					String productNumber = products.signup(new IndustrialProducts(products.generateID(), name, 0,
							availableProducts, price, category, brand, name));
					System.out.println("\nThe Product Id: " + productNumber + " was successfully created!");
				}
				}

				keyPress();
				break;
			case 2:
				Format.title("Show all Products");

				products.showAll();

				keyPress();
				break;
			case 3:
				Format.title("Search Product's Data - by ID");

				System.out.print(Colors.TEXT_RESET);

				System.out.println("Enter the Account's ID: ");
				sc.nextLine();
				id = sc.nextLine();

				System.out.println();

				products.searchByNumber(id);

				keyPress();
				break;
			case 4:
				Format.title("Update Product data");

				System.out.print(Colors.TEXT_RESET);

				System.out.println("Enter the Account's ID: ");
				sc.nextLine();
				id = sc.nextLine();

				var searchProduct = products.searchInCollection(id);

				if (searchProduct != null) {

					type = searchProduct.getType();

					System.out.print(Colors.TEXT_RESET);

					System.out.print("Enter the Product's Name: ");
					name = sc.nextLine();
					System.out.print("Enter the Product's Price: ");
					price = sc.nextFloat();
					System.out.print("Enter the Available Amount: ");
					availableProducts = sc.nextInt();
					System.out.print("Enter the Total Sales: ");
					totalSales = sc.nextInt();
					System.out.print("Enter the Product's category: ");
					sc.skip("\\R?");
					category = sc.nextLine();
					System.out.print("Enter the Product's Brand: ");
					brand = sc.nextLine();

					switch (type) {
					case 1 -> {
						System.out.print("Enter Client Name: ");
						nameType = sc.nextLine();

						products.update(new ConsumerProducts(id, name, totalSales, availableProducts, price, category,
								brand, nameType));
					}
					case 2 -> {
						System.out.print("Enter Industry Name: ");
						nameType = sc.nextLine();

						products.update(new IndustrialProducts(id, name, totalSales, availableProducts, price, category,
								brand, nameType));

					}
					default -> {
						Format.text("Invalid Product Type!", 0,0,false);
					}
					}

				} else {
					Format.text("Product not Found!", 0,0,false);
				}

				keyPress();
				break;
			case 5:
				Format.title("Delete Product");

				System.out.print(Colors.TEXT_RESET);

				System.out.println("Enter the Account's ID: ");
				sc.nextLine();
				id = sc.nextLine();

				products.delete(id);

				keyPress();
				break;
			case 6:
				System.out.print(Colors.TEXT_BLACK);
				credits();
				sc.close();
				break;
			default:
				Format.stars("\n" + Colors.TEXT_RED_BOLD);
				Format.text("Invalid Option!", 0, 1, true);
				Format.stars("");
				System.out.print(Colors.TEXT_RESET + "\n");
				break;
			}

		} while (option != 6);

	}

	public static void credits() {
		Format.stars("");
		Format.text("Coded by Sarah Yukino Nakada", 0, 1, true);
		Format.text("github.com/sarassaura       ", 0, 1, true);
		Format.stars("");
	}

	public static void keyPress() {
		try {
			System.out.println(Colors.TEXT_RESET + "\nPress Enter to Continue...");
			System.in.read();

		} catch (IOException e) {
			System.out.println("You pressed a key other than enter\n!");
		}
	}
}
