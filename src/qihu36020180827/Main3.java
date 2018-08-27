package qihu36020180827;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr1 = new int[n],arr2 = new int[n];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			arr1[i] = in.nextInt();
		for (int i = 0; i < n; i++)
			arr2[i] = in.nextInt();
		int res = 0;

		int start = 0, end = 1;
		
//		while (start < n - 1) {
//			if (end == n)
//				break;
//			sb = new StringBuilder();
//			for (int i = start; i <= end; i++)
//				sb.append(arr1[i]);
//			if (b.contains(sb.reverse().toString())) {
//				res = Math.max(res, sb.length());
//			} else 
//				start = end;
//			end++;
//		}
		System.out.println(res);
		in.close();
	}

}
