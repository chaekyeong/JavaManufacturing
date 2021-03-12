package com.account;

public class Example01 {
	public static void main(String[] args) {
		int[][] myNumbers = {{2, 3, 4, 5, 6, 7, 8, 9}, {1, 2, 3, 4, 5, 6, 7, 8, 9}};
		
		for (int i = 0; i < myNumbers[0].length; i++) {
			for (int j = 0; j <myNumbers[1].length; j++) {
				System.out.print(myNumbers[0][i] + "*" + myNumbers[1][j] + "= " + myNumbers[0][i] * myNumbers[1][j]);
				System.out.println();
			}
		}
	}
}
