package haoweilai20180828;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String s = scan.nextLine();

		if (s.equals("") || s.length() == 0) {

			System.out.println(0);

			return;

		}
		String[] str = s.split(" ");

		int len = str.length;

		int[] arr = new int[len];

		for (int i = 0; i < len; i++) {

			arr[i] = Integer.parseInt(str[i]);

		}

		int res = maxSequence(arr);
		System.out.println(res);
		scan.close();
	}

	private static int maxSequence(int[] arr) {
		int len = arr.length;
		if (len <= 1)
			return arr[0];
		int[] dp = new int[len]; // dp[i]表示以arr[i]结尾的递增子序列的和
		int max = 0;
		for (int i = 0; i < len; i++) {
			dp[i] = arr[i]; // 初始化
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
			}
			max = max < dp[i] ? dp[i] : max;
		}
		return max;
	}
}
