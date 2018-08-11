package wangyi20190811;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] apples = new int[n]; // apples[i]表示前i+1堆共有多少苹果
		apples[0] = in.nextInt();
		for (int i = 1; i < n; i++)
			apples[i] = apples[i - 1] + in.nextInt();
		int m = in.nextInt();
		while (m-- > 0) {
			int q = in.nextInt();
			System.out.println(search(apples, q));
		}
		in.close();
	}

	private static int search(int[] apples, int q) {
		int lo = 0, hi = apples.length - 1;
		while (lo < hi) {
			int mid = lo + ((hi - lo) >> 1);
			if (apples[mid] < q)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return apples[lo] >= q ? lo + 1 : (lo + 2);
	}
}
