package com.ayush.skillenza;

public class FindBestPath {

	public static void main(String[] args) {
		int[][] matrix = {  { 0, 1, 1, 1, -1 }, 
							{ 1, -1, -1, -1, 1 }, 
							{ 1, -1, 9, -1, 1 }, 
							{ 1, -1, -1, -1, 1 },
							{ -1, 1, 1, 1, 0 } };

		findBestPath2(matrix);
	}

	public static void findBestPath2(int[][] matrix) {
		int[][] cost = new int[2][matrix[0].length];
		cost[0][0] = matrix[0][0];

		for (int i = 0; i < matrix.length; i++) {
			int iUp = 0;
			int iAt = 0;
			if (i % 2 == 0) {
				iUp = 1;
				iAt = 0;
			} else {
				iUp = 0;
				iAt = 1;
			}
			for (int j = 0; j < matrix[0].length; j++) {
				if (i + 1 < matrix.length && matrix[i + 1][j] != -1 && cost[iAt][j] + matrix[i + 1][j] > cost[iUp][j]) {
					cost[iUp][j] = cost[iAt][j] + matrix[i + 1][j];
				}
				if (j + 1 < matrix.length && matrix[i][j + 1] != -1
						&& cost[iAt][j] + matrix[i][j + 1] > cost[iAt][j + 1]) {
					cost[iAt][j + 1] = cost[iAt][j] + matrix[i][j + 1];
				}
			}
		}
		if (matrix.length % 2 == 0) {
			System.out.println("Max is " + cost[1][matrix[0].length - 1]);
		} else {
			System.out.println("Max is " + cost[0][matrix[0].length - 1]);
		}
	}

}