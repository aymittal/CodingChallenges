package com.ayush.skillenza;

import java.math.BigInteger;
import java.util.Scanner;

public class BinaryMadness {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int n = 0; n < testCases; n++) {
			BigInteger number = sc.nextBigInteger();
			String numberToBinaryString = number.toString(2);
			int count1 = number.bitCount(), cases = 0;
			for (int k = 1; k <= count1; k += 2) {
				cases += countOfSubstringWithKOnes(numberToBinaryString, k);
			}
			System.out.println(cases);
		}
	}

	static int countOfSubstringWithKOnes(String s, int K) {
		int N = s.length();
		int res = 0;
		int countOfOne = 0;
		int[] freq = new int[N + 1];

		freq[0] = 1;
		for (int i = 0; i < N; i++) {
			countOfOne += (s.charAt(i) - '0');
			if (countOfOne >= K) {
				res += freq[countOfOne - K];
			}
			freq[countOfOne]++;
		}
		return res;
	}
}
