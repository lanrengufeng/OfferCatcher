package haoweilai20180828;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int x = in.nextInt();
			int k = in.nextInt();
			char[] xs = Integer.toBinaryString(x).toCharArray();
			char[] ks = Integer.toBinaryString(k).toCharArray();
			char[] tmp = new char[xs.length];
			Arrays.fill(tmp, '0');
			int p1 = xs.length - 1, p2 = ks.length - 1;
			while (p2 >= 0) {
				if (ks[p2] == '1') {
					while (xs[p1] != '0')
						p1--;
					tmp[p1] = '1';
					xs[p1] = '1';
				}else {
					while (xs[p1] != '0')
						p1--;
					p1--;
				}
				p2--;
			}
			System.out.println(Integer.parseInt(new String(tmp), 2));
		}

		in.close();
	}
}
