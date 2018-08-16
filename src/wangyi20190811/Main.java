package wangyi20190811;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), k = in.nextInt();
		int[] score = new int[n], awake = new int[n];
		for (int i = 0; i < n; i++)
			score[i] = in.nextInt();
		for (int i = 0; i < n; i++)
			awake[i] = in.nextInt();
		int sum = 0, max = 0, window = 0, left = 0; // left和i组成 大小为k的窗口
		for (int i = 0; i < n; i++) {
			sum += score[i] * awake[i];
			if (i < k) {
				window += score[i] * (awake[i] ^ 1);
			} else {
				max = Math.max(max, window);
				window = window + score[i] * (awake[i] ^ 1) - score[left] * (awake[left++] ^ 1);
			}
		}
		// for (int i = 0; i < n; i++) {
		// if (awake[i] == 1)
		// sum += score[i];
		// if (i < k) {
		// if (awake[i] == 0)
		// window += score[i];
		// } else {
		// max = Math.max(max, window);
		// if (awake[i] == 0) {
		// window = awake[left] == 0 ? window - score[left] + score[i] : window + score[i];
		// } else
		// window = awake[left] == 0 ? window - score[left] : window;
		// left++;
		// }
		// }
		max = Math.max(max, window);
		System.out.println(sum + max);
		in.close();
	}

	private static int getSum(int[] score, int[] awake, int index, int k) {
		int sum = 0;
		for (int i = index; i < score.length && k > 0; i++, k--) {
			if (awake[i] == 0)
				sum += score[i];
		}
		return sum;
	}
}
