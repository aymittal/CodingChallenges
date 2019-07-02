package com.ayush.skillenza;

import java.util.Scanner;

public class NumberOfPies {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfDays = sc.nextInt();
		for (int n = 0; n < numberOfDays; n++) {
			int numberOfPies = sc.nextInt();
			int weightOfPies[] = new int[numberOfPies];
			for (int i = 0; i < numberOfPies; i++) {
				weightOfPies[i] = sc.nextInt();
			}
			int weight_to_be_delivered = sc.nextInt();
			if (isSubsetSum(weightOfPies, numberOfPies, weight_to_be_delivered))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	static boolean isSubsetSum(int weightOfPies[], int numberOfPies, int weight_to_be_delivered) {
		if (weight_to_be_delivered == 0)
			return true;
		if (numberOfPies == 0 && weight_to_be_delivered != 0)
			return false;
		if (weightOfPies[numberOfPies - 1] > weight_to_be_delivered)
			return isSubsetSum(weightOfPies, numberOfPies - 1, weight_to_be_delivered);

		return isSubsetSum(weightOfPies, numberOfPies - 1, weight_to_be_delivered) || isSubsetSum(weightOfPies, numberOfPies - 1, weight_to_be_delivered - weightOfPies[numberOfPies - 1]);
	}
}