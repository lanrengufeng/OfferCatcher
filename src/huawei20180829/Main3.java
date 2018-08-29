package huawei20180829;

import java.util.Scanner;

/**
 * a(n) = a(m-1)+a(m-4)
 * 
 * @author Watcher
 *
 */
public class Main3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while (n-- > 0) {
			int num = in.nextInt();
			int month = in.nextInt();
			long res = getNum(num, month);
			System.out.println(res);
		}
		in.close();
	}

	private static long getNum(int num, int month) {
		if (month <= 4)
			return num * (month + 1);
		else {
			int[] nums = new int[month + 1];
			nums[1] = 2 * num;
			nums[2] = 3 * num;
			nums[3] = 4 * num;
			nums[4] = 5 * num;
			for (int i = 5; i <= month; i++) {
				nums[i] = nums[i - 1] + nums[i - 4];
			}
			return nums[month];
		}

	}
}
