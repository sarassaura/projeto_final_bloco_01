package stock.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Xception {
	
	public static int Inteiro() {
		Scanner sc = new Scanner(System.in);
		
		do {
			try {
				System.out.print(Colors.TEXT_RESET);
				return sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.print(Colors.TEXT_YELLOW + Colors.ANSI_BLACK_BACKGROUND);
				Format.text("Enter Integer Values!", 1, 1, true);
				sc.nextLine();
			}
		} while (true);
	
	}
	
}
