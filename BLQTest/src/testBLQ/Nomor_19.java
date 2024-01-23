package testBLQ;

import java.util.Scanner;

public class Nomor_19 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("input : ");
		String in = scanner.nextLine();
		int len = in.length();

		if (allLetterCheck(in, len)) {
			System.out.println("pangram");
		} else {
			System.out.println("bukan pangram");
		}

	}

	public static boolean isLetter(char ch) {
		if (!Character.isLetter(ch)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean allLetterCheck(String str, int len) {
		int size = 26;
		str = str.toLowerCase();
		boolean[] present = new boolean[size];

		for (int i = 0; i < len; i++) {
			if (isLetter(str.charAt(i))) {
				int letter = str.charAt(i) - 'a';
				present[letter] = true;
			}
		}

		for (int i = 0; i < size; i++) {
			if (!present[i])
				return false;
		}
		return true;
	}
}
