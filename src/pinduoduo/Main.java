package pinduoduo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		char[] cs = str.toCharArray();
		int k = cs.length / 4, len = str.length();
		System.out.println(str.substring(0, k + 1));

		for (int i = 1; i < k; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(cs[len - i]);
			for (int j = 0; j < k - 1; j++)
				sb.append(' ');
			sb.append(cs[k + i]);
			System.out.println(sb.toString());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 3 * k; i >= 2 * k; --i)
			sb.append(cs[i]);
		System.out.println(sb.toString());
		in.close();
	}
}
