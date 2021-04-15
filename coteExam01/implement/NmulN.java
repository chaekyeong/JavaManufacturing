package implement;

import java.util.Scanner;

public class NmulN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기
		int x = 1;
		int y = 1;

		int n = sc.nextInt();
		sc.nextLine();
		String m = sc.nextLine();
		String[] move = m.split(" ");

		for (int i = 0; i < move.length; i++) {
			
			if (y == 1 && move[i].equals("L")) {
				continue;
			} else if (y == n && move[i].equals("R")) {
				continue;
			} else if (x == 1 && move[i].equals("U")) {
				continue;
			} else if (x == n && move[i].equals("D")) {
				continue;
			}
			
			if (move[i].equals("L")) {
				y -= 1;
				continue;
			} else if (move[i].equals("R")) {
				y += 1;
				continue;
			} else if (move[i].equals("U")) {
				x -= 1;
				continue;
			} else if (move[i].equals("D")) {
				x += 1;
				continue;
			}
		}
		System.out.println(x +" " +y);
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기 
		long secDiffTime = (afterTime - beforeTime) / 1000; // 두 시간에 차 계산
		System.out.println("시간차이(m) : " + secDiffTime);
	}
}
