package toutiao20180825;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), t = in.nextInt();
		int[] data = new int[n * t];
		int[] tmp = new int[n];
		for (int i = 0; i < n; i++)
			tmp[i] = in.nextInt();
		for (int i = 0; i < data.length; i++)
			data[i] = tmp[i % n];
		int max = maxSequence(data, new boolean[n*t]);
		System.out.println(max);
		in.close();
	}

	private static int maxSequence(int[] arr, boolean[] used) {
		int len = arr.length;
		if (len <= 1)
			return 1;
		int[] dp = new int[len]; // dp[i]表示以arr[i]结尾的递增子序列长度.
		int max = 0;
		for (int i = 0; i < len; i++) {
			if (used[i])
				continue;
			dp[i] = 1; // 初始化
			for (int j = 0; j < i; j++) {
				if (!used[j] && arr[i] >= arr[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = max < dp[i] ? dp[i] : max;
		}
		return max;
	}
}
