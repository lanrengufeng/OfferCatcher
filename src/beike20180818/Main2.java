package beike20180818;

import java.util.Scanner;

/**
 * 区间极差和
 * 
 * @author Watcher
 *
 */
public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] data = new int[n];
		long res = 0;
		for (int i = 0; i < n; i++)
			data[i] = in.nextInt();
		res = getDiff(data, 0, n - 1);
		System.out.println(res);
		in.close();
	}

	private static long getDiff(int[] data, int left, int right) {
		if (left == right)
			return 0;
		int res = 0;
		int[] idx = getIndex(data, left, right);
		int lo = idx[0], hi = idx[1];
		if (lo == hi)
			return 0;
		res += (lo - left + 1) * (right - hi + 1) * Math.abs(data[lo] - data[hi]);
		res += getDiff(data, left, hi - 1) + getDiff(data, lo + 1, right) - getDiff(data, lo + 1, hi - 1);
		return res;
	}

	private static int[] getIndex(int[] data, int left, int right) {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, maxIndex = 0, minIndex = 0;
		for (int i = left; i <= right; i++) {
			if (data[i] > max) {
				max = data[i];
				maxIndex = i;
			}
			if (data[i] < min) {
				min = data[i];
				minIndex = i;
			}
		}
		if (maxIndex < minIndex)
			return new int[] { maxIndex, minIndex };
		else
			return new int[] { minIndex, maxIndex };
	}
}
