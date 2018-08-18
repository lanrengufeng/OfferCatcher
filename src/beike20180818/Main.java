package beike20180818;

import java.util.Scanner;

/**
 * 总耗电量
 * 
 * @author Watcher
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), p1 = in.nextInt(), p2 = in.nextInt(), p3 = in.nextInt(), t1 = in.nextInt(), t2 = in.nextInt();
		int[][] scope = new int[n][2];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			scope[i][0] = in.nextInt();
			scope[i][1] = in.nextInt();
			sum += (scope[i][1] - scope[i][0]) * p1; // 工作时间耗电
		}

		for (int i = 1; i < n; i++) {
			int diff = scope[i][0] - scope[i - 1][1]; // 两次工作间隔
			if (diff <= t1)
				sum += diff * p1;
			else {
				sum += t1 * p1;
				diff -= t1;
				if (diff <= t2)
					sum += diff * p2;
				else {
					sum += t2 * p2;
					diff -= t2;
					if (diff > 0)
						sum += diff * p3;
				}
			}
		}
		System.out.println(sum);
		in.close();
	}
}
