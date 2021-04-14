package greedy;

import java.util.Scanner;

public class NumberCardGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int row = sc.nextInt();
		int col = sc.nextInt();
		
		int result = 0;
		for (int i = 0; i < row; i++) {
			int minVal = 10000;
			for (int j = 0; j < col; j++) {
				int num = sc.nextInt();
				minVal = Math.min(minVal, num);
			}
			result = Math.max(minVal, result);
		}
		System.out.println(result);
	}
}
