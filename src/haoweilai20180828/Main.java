package haoweilai20180828;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int res = 0, left = 0;
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '0' || cs[i] == '3' || cs[i] == '6' || cs[i] == '9') {
				res++;
				res += getNum(cs, left, i - 1);
				left = i + 1;
			}
		}
		res += getNum(cs, left, cs.length - 1);
		System.out.println(res);
		in.close();
	}

	/**
	 * char[] cs 中从left到right能组成几个3的倍数
	 * 
	 * @param cs
	 * @param left
	 * @param right
	 * @return
	 */
	private static int getNum(char[] cs, int left, int right) {
		if (left >= right)
			return 0;
		int res = 0;
		res = backtrack(cs, right, left, 0, 0);
		return res;
	}

	private static int backtrack(char[] cs, int right, int index, int cnt, int res) {
		if (index >= right) {
			res = Math.max(res, cnt);
			return res;
		}
		int num = 0;
		for (int i = index; i <= right; i++) {
			for (int j = i; j <= right; j++) {
				num += cs[j] - '0';
				if (num % 3 == 0) {
					res = backtrack(cs, right, j + 1, cnt + 1, res);
					break;
				}
			}
		}
		return res;
	}
}
