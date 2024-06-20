package stock;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import stock.util.Colors;
import stock.util.Format;

public class Menu {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int option = 0;
		
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

				keyPress();
				break;
			case 2:
				Format.title("Show all Products");

				keyPress();
				break;
			case 3:
				Format.title("Search Product's Data - by ID");

				keyPress();
				break;
			case 4:
				Format.title("Update Product data");

				System.out.print(Colors.TEXT_RESET);

				keyPress();
				break;
			case 5:
				Format.title("Delete Product");

				System.out.print(Colors.TEXT_RESET);

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
		Format.text("Coded by Sarah Yukino Nakada                 ", 0, 1, true);
		Format.text("github.com/sarassaura                        ", 0, 1, true);
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
