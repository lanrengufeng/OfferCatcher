package huiding;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		// int res = find(n, k);
		int res = ysf(n, k);
		System.out.println(res);
		in.close();
	}

	public static int find(int total, int cnt) {
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= total; i++) {
			list.add(i);
		}
		int k = 0;
		for (int i = 1; i < total; i++) {
			k = (k + cnt - 1) % list.size();
			list.remove(k);
		}

		return list.get(0);
	}

	private static int ysf(int n, int k) {
		int p = 0;
		for (int i = 2; i <= n; i++) {
			p = (p + k) % i;
		}
		return p + 1;
	}
}
