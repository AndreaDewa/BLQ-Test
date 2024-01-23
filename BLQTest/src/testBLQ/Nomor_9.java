package testBLQ;

import java.util.Scanner;

public class Nomor_9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("nilai : ");
		int n = scanner.nextInt();
		scanner.nextLine();

		int x = 0;
		for (int i = 0; i < n; i++) {
			x = x + n;

			System.out.print(x + " ");
		}

	}
}
