package testBLQ;

import java.util.Scanner;

public class Nomor_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Panjang data yang akan Ditampilkan : ");
		int n = scanner.nextInt();
		scanner.nextLine();
		
		int x = 0;
		int y = 1;
		System.out.print(x+" "+y);
		int z ;
		for (int i = 2; i <= n; i++) {
			z = x + y;
			System.out.print(" "+z);
			x = y;
			y = z;
		}
	}

}
