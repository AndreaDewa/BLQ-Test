package testBLQ;

import java.util.Scanner;

public class Nomor_4 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Panjang data yang akan Ditampilkan : ");
		int n = scanner.nextInt();
		scanner.nextLine();

		for (int i = 1; i <= n; i++) {
			int x = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					x++;
				}
			}
			if(x == 2) {
				System.out.print(i+" ");
			}
		}

	}
}
