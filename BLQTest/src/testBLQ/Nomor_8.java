package testBLQ;

import java.util.Arrays;
import java.util.Scanner;

public class Nomor_8 {
	public static void main(String[] args) {
		int[] arrDeret = { 2, 4, 7, 3, 6, 8, 4 };

		System.out.println("nilai minimum : " + count4itemMin(arrDeret));
		System.out.println("nilai maksimum : " + count4itemMax(arrDeret));

	}

	public static int count4itemMin(int[] deret) {
		int[] arrSort = deret;
		Arrays.sort(arrSort);
		int sum4 = 0;
		for (int i = 0; i < 4; i++) {
			sum4 = sum4 + arrSort[i];
		}
		return sum4;

	}

	public static int count4itemMax(int[] deret) {
		int[] arrSort = deret;
		Arrays.sort(arrSort);
		int sum4 = 0;
		for (int i = arrSort.length - 1; i >= arrSort.length - 4; i--) {
			sum4 = sum4 + arrSort[i];
		}
		return sum4;

	}
}
