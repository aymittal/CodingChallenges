package com.ayush.skillenza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 
Arya has always been obsessed about arrays. 
She recently had a visitor who challenged her in an array challenge. 
The visitor gave her two arrays that contain n positive integers 
and asked her to check if the arrays are equal. 
The arrays are equal if both the arrays contain the same integers. 
The order doesn’t matter.

If they are unequal, she needs to find the smallest positive integer 
that can be added to any one of the integers of any of the arrays to 
make them equal.

Input Format-
The first line of input consists of an integer t which denotes the number of test cases

The first line of each test case contains an integer n 
which denotes the size of both arrays

The second line of each test case contains n space separated 
integers denoting the first array

The third line of each test case contains n space separated 
integers denoting the second array

Output Format-
For each test case

If the arrays are equal, print Yes

If the arrays are unequal, print two space separated 
integers p and q. Here p is the smallest positive integer 
that needs to be added to an integer of array q. 
If p needs to be added to the first array, 
then q is 1 and if it needs to be added to the second array q is 2

If there is no such integer, then print No
 * 
 */
public class ArrayChallenge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int n = 0; n < testCases; n++) {
			int no_of_elements = sc.nextInt();
			List<Integer> arrayP = new ArrayList<>();
			List<Integer> arrayQ = new ArrayList<>();
			for (int i = 0; i < no_of_elements; i++) {
				arrayP.add(sc.nextInt());
			}
			for (int i = 0; i < no_of_elements; i++) {
				int value = sc.nextInt();
				if (arrayP.contains(value)) {
					arrayP.remove(arrayP.indexOf(value));
				} else
					arrayQ.add(value);
			}
			if (arrayP.size() == 0) {
				System.out.println("Yes");
			} else if (arrayP.size() > 2) {
				System.out.println("No");
			} else {
				Collections.sort(arrayP);
				Collections.sort(arrayQ);
				if (arrayP.get(0) > arrayQ.get(0)) {
					System.out.println(Math.abs(arrayP.get(0) - arrayQ.get(0)) + " " + "2");
				} else
					System.out.println(Math.abs(arrayP.get(0) - arrayQ.get(0)) + " " + "1");

			}
		}
	}
}
