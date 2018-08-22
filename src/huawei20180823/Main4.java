package huawei20180823;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		if (str == null)
			System.out.println(" " + 0);
		String res = null;
		int max = 0, start = 0;
		for (int i = 1; i < str.length(); i++) {
			int tmp = 0;
			for (int j = 0; j < str.length() - i; j++) {
				if (str.charAt(j) == str.charAt(j + i))
					tmp++;
				else
					tmp = 0;
				if (tmp > max) {
					max = tmp;
					start = j - max + 1;
				}
			}
		}
		if (max > 0) {
			res = str.substring(start, start + max);
		}
		if (res != null)
			System.out.println(res + " " + res.length());
		else
			System.out.println(" " + 0);
		in.close();
	}
}
