package qihu36020180827;

import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = in.nextInt();
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int l = in.nextInt(), r = in.nextInt();
			int res = count(arr, l - 1, r - 1);
			System.out.println(res);
		}
		in.close();
	}

	private static int count(int[] arr, int start, int end) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = start; i <= end; i++)
			set.add(arr[i]);
		return set.size();
	}
}
