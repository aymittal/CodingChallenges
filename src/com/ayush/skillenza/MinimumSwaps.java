package com.ayush.skillenza;

import java.util.Scanner;

public class MinimumSwaps {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int min_steps = 0;
			int mid_m1, mid_m2, mid_n1, mid_n2;
			if(m % 2 == 0) {
				mid_m1 = m/2;
				mid_m2 = mid_m1 - 1;
			}else {
				mid_m1 = m / 2;
				mid_m2 = mid_m1;
			}
			if(n % 2 == 0) {
				mid_n1 = n/2;
				mid_n2 = mid_n1 - 1;
			}else {
				mid_n1 = n / 2;
				mid_n2 = mid_n1;
			}
			int max_in_matrix = Integer.MIN_VALUE;
			int a[][] = new int[m][n];
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					a[j][k] = sc.nextInt();
					if (max_in_matrix < a[j][k]) {
						max_in_matrix = a[j][k];
						min_steps = Integer.min(findSteps(j, k, mid_m1, mid_n1), findSteps(j, k, mid_m2, mid_n2));
					}else if(max_in_matrix == a[j][k]) {
						int steps = Integer.min(findSteps(j, k, mid_m1, mid_n1), findSteps(j, k, mid_m2, mid_n2));
						min_steps = Integer.min(steps, min_steps);
					}
				}
			}
			System.out.println(min_steps);
		}
	}
	
	public static int findSteps(int max_m, int max_n, int mid_m, int mid_n) {
		int count = 0;
		while (mid_m != max_m) {
			if (mid_m < max_m) {
				max_m--;
				count++;
			} else if (mid_m > max_m) {
				max_m++;
				count++;
			}
		}
		while (mid_n != max_n) {
			if (mid_n < max_n) {
				max_n--;
				count++;
			} else if (mid_n > max_n) {
				max_n++;
				count++;
			}
		}
		return count;
	}
}
