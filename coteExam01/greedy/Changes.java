package greedy;
// 거스름돈
public class Changes {
	public static void main(String[] args) {
		int n = 1260;
		int cnt = 0;
		
		int[] changes = {500, 100, 50, 10};
		
		for (int i = 0; i < changes.length; i++) {
			cnt += (n / changes[i]);
			n %= changes[i];
		}
		System.out.println(cnt);
	}
}
