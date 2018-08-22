package huawei20180823;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		System.out.println(longest(str));
		in.close();
	}

	public static int longest(String s) {
		if (s == null || s.length() < 2)
			return 0;
		char[] ss = s.toCharArray();
		int len = ss.length;
		int[] dp = new int[len];
		if (ss[0] == '(' && ss[1] == ')')
			dp[1] = 2;
		int res = dp[1]; // 返回值
		for (int i = 2; i < len; i++) {
			char cur = ss[i];
			if (cur == '(')
				continue;
			if (cur == ')' && ss[i - 1] == '(')
				dp[i] = dp[i - 2] + 2;
			else if (cur == ')') {
				if (i - dp[i - 1] - 1 >= 0 && ss[i - dp[i - 1] - 1] == '(') {
					int before = i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0;
					dp[i] = dp[i - 1] + before + 2;
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}

}
