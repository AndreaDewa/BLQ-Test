package testBLQ;

import java.util.Scanner;

public class Nomor_15 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("input (hh:mm:ssAM/PM) : ");
		String in = scanner.nextLine();
		print24format(in);
	}
	
	
	static void print24format(String input) {
		// Get hours
		int h1 = (int) input.charAt(1) - '0';
		int h2 = (int) input.charAt(0) - '0';
		int hh = (h2 * 10 + h1 % 10);

		//  "AM"
		if (input.charAt(8) == 'A') {
			if (hh == 12) {
				System.out.print("00");
				for (int i = 2; i <= 7; i++)
					System.out.print("Output : "+input.charAt(i));
			} else {
				for (int i = 0; i <= 7; i++)
					System.out.print("Output : "+input.charAt(i));
			}
		}

		//  "PM"
		else {
			if (hh == 12) {
				System.out.print("12");
				for (int i = 2; i <= 7; i++)
					System.out.print("Output : "+input.charAt(i));
			} else {
				hh = hh + 12;
				System.out.print(hh);
				for (int i = 2; i <= 7; i++)
					System.out.print("Output : "+input.charAt(i));
			}
		}
	}



}
