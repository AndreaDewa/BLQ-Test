package testBLQ;

import java.util.Scanner;

public class Nomor_12 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("input : ");
		String in = scanner.nextLine();

		String[] arrIn = in.split(" ");
		int[] arrint = new int[arrIn.length];

		for (int i = 0; i < arrIn.length; i++) {
			arrint[i] = Integer.parseInt(arrIn[i]);
		}

		sortData(arrint);
	}

	public static void sortData(int[] data) {
		int temp = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] > data[j]) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		System.out.print("Output : ");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}

	}
}
