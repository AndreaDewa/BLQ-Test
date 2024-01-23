package testBLQ;

import java.util.Scanner;

public class Nomor_6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Jumlah Uang : ");
		String kata = scanner.next();
		scanner.nextLine();
		String dumm = "";
		for (int i = kata.length()-1; i >= 0 ; i--) {
			dumm = dumm + kata.charAt(i);
		}
		
		if(dumm.equalsIgnoreCase(kata)) {
			System.out.println(kata+" reverse to "+dumm);
			System.out.println("Palindrome");
		}else {
			System.out.println(kata+" reverse to "+dumm);
			System.out.println("Not Palindrome");
		}
	}
}
