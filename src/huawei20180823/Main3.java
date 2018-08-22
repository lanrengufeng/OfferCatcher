package huawei20180823;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		if (str == null || str.length() < 8)
			System.out.println(" " + 0);
		else {
			int start = 0, len = 4, max = 0;
			String res = "";
			while (start <= str.length() - 8) {
				len = 4;
				String cur = str.substring(start, start + len);
				String s = str.substring(start + len);
				while (s.contains(cur) && s.length() >= cur.length()) {
					if (len > max) {
						max = len;
						res = cur;
					}
					len++;
					cur = str.substring(start, start + len);
					s = str.substring(start + len);
				}
				start++;
			}
			if (max == 0)
				System.out.println(" " + max);
			else
				System.out.println(res + " " + max);

		}
		in.close();
	}

}
