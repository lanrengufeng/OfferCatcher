package pinduoduo;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int res = 0;
		for (int i = 1; i < str.length(); i++)
			res += count(str.substring(0, i), str.substring(i));
		System.out.println(res);
		in.close();

	}

	private static int count(String s1, String s2) {
		int cnt1 = 0, cnt2 = 0; // 字符串可以组成的数字个数
		if ((s1.length() > 1 && s1.startsWith("0") && s1.endsWith("0")) || (s2.length() > 1 && s2.startsWith("0") && s2.endsWith("0")))
			return 0;
		if (s1.startsWith("0") || s1.endsWith("0"))
			cnt1 = 1;
		else
			cnt1 = s1.length();
		if (s2.startsWith("0") || s2.endsWith("0"))
			cnt2 = 1;
		else
			cnt2 = s2.length();
		return cnt1 * cnt2;
	}
}
