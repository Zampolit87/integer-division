package ua.com.foxminded;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		IntegerDivision integerDivision = new IntegerDivision();
		System.out.println("Enter positive dividend");
		int dividend = scanner.nextInt();
		System.out.println("Enter positive divisor");
		int divisor = scanner.nextInt();
		DivisionResult result = integerDivision.divide(dividend, divisor);
		DivisionFormatter formatter = new DivisionFormatter();
		System.out.println(formatter.format(result));
		scanner.close();
	}
}
