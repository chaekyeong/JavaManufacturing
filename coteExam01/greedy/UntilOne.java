package greedy;

import java.util.Scanner;

public class UntilOne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int cnt = 0;
		
		while(true) {
			if (n % k != 0) {
				n -= 1;
				cnt++;
			} else {
				n /= k;
				cnt++;
			}
			

			if (n == 1) {
				break;
			}
		}
	}
}
