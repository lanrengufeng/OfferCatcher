package pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {

	static int total; // 已经获取的卡片数量
	static int nextMax; // 下一轮的最长递增(减)序列长度
	static int res;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = in.nextInt();
		boolean[] used = new boolean[n]; // used[i]=true表示当前卡片已被取过，暂时的卡片状态
		boolean[] state = new boolean[n]; // 真正的每轮过后的状态
		while (total != n) {
			int[] way = maxSequence(arr, used);
			int last = way[0] == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			used = backtrack(way, 0, 0, last, used, state, arr);
			total += way[1];
			nextMax = 0;
			res++;
		}
		System.out.println(res);
		in.close();
	}

	/**
	 * total：已获取地总卡片数；way：递增或递减以及其长度；index：开始下标；cur:本次已获取的卡片数；used：状态;last:上一次的取值
	 * 
	 * @param total
	 * @param way
	 * @param index
	 * @param cur
	 * @param used
	 * @return
	 */
	private static boolean[] backtrack(int[] way, int index, int cur, int last, boolean[] used, boolean[] state, int[] arr) {
		if (cur == way[1]) { // 本次取的卡片数已经达到最大数量
			int[] nextWay = maxSequence(arr, used);
			if (nextWay[1] > nextMax) {
				nextMax = nextWay[1];
				return state = Arrays.copyOf(used, used.length);
			}
		}
		for (int i = index; i < arr.length; i++) {
			if (used[i])
				continue;
			if (way[0] == 0 && arr[i] > last) { // 递增地取卡片
				used[i] = true;
				state = backtrack(way, index + 1, cur + 1, arr[i], used, state, arr);
				used[i] = false;
			} else if (way[0] == 1 && arr[i] < last) {
				used[i] = true;
				state = backtrack(way, index + 1, cur + 1, arr[i], used, state, arr);
				used[i] = false;
			}
		}
		return state;
	}

	/**
	 * 求最长递增(减)子序列的长度，int[0]:0为递增，1为递减；int[1]表示序列长度;
	 * 
	 * @param arr
	 * @return
	 */
	private static int[] maxSequence(int[] arr, boolean[] used) {
		int len = arr.length;
		if (len <= 1)
			return new int[] { 0, 1 };
		int[] dp1 = new int[len]; // dp1[i]表示以arr[i]结尾的递增子序列长度.
		int[] dp2 = new int[len]; // dp2[i]表示以arr[i]结尾的递减子序列长度
		int max1 = 0, max2 = 0;
		for (int i = 0; i < len; i++) {
			if (used[i])
				continue;
			dp1[i] = dp2[i] = 1; // 初始化
			for (int j = 0; j < i; j++) {
				if (!used[j] && arr[i] > arr[j])
					dp1[i] = Math.max(dp1[i], dp1[j] + 1);
				if (!used[j] && arr[i] < arr[j])
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
			}
			max1 = max1 < dp1[i] ? dp1[i] : max1;
			max2 = max2 < dp2[i] ? dp2[i] : max2;
		}
		if (max1 >= max2)
			return new int[] { 0, max1 };
		else
			return new int[] { 1, max2 };
	}
}
