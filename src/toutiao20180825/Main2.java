package toutiao20180825;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		final int mod = 1000000007;
		if (n <= 0)
			System.out.println(0);
		else if (n == 1)
			System.out.println(10);
		else if (n == 2)
			System.out.println(100);
		else {
			long[] dp = new long[n + 1];
			dp[1] = 10;
			dp[2] = 100;
			dp[3] = 1210;
			for (int i = 4; i <= n; i++) {
				dp[i] = ((10 * (dp[i - 1] - dp[i - 3])) % mod + (21 * dp[i - 2]) % mod) % mod;
			}

			System.out.println(dp[n]);
		}
		in.close();
	}
}
