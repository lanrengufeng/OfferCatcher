package pinduoduo;

import java.util.ArrayList;
import java.util.Scanner;


public class Main2 {

	static int res = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int len = str.length();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i < len - 1; i++)
			join(list, str.substring(0, i), str.substring(i));
		System.out.println(res);
		in.close();
	}

	private static void join(ArrayList<String> list, String s1, String s2) {
		if (list.contains(s1 + "-" + s2))
			return;
		// 过滤只含有多个0的情况
		if ((s1.length() > 1 && Integer.parseInt(s1) == 0) || (s2.length() > 1 && Integer.parseInt(s2) == 0))
			return;
		

		// 加小数点
		for (int i = 1; i <= s1.length(); i++) {
			StringBuilder sb = new StringBuilder(s1);
			sb.insert(i, '.');
			res++;
			for (int j = 1; j <= s2.length() - 1; j++) {
				StringBuilder sb2 = new StringBuilder(s2);
				sb2.insert(j, '.');
				list.add(sb.toString() + "-" + sb2.toString());
				res++;
			}
		}
	}
}
