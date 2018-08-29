package huawei20180829;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] arr1 = new int[9][2];
		int[][] arr2 = new int[9][2];
		for (int i = 4; i >= 0; i--) {
			arr1[i][0] = in.nextInt();
			arr1[i][1] = in.nextInt();
		}
		for (int i = 4; i >= 0; i--) {
			arr2[i][0] = in.nextInt();
			arr2[i][1] = in.nextInt();
		}
		int[][] res = new int[9][2];
		for (int i = 0; i < 9; i++) {
			for (int k = 0, j = i; k <= i; k++, j--) {
				res[i][0] += arr1[k][0] * arr2[j][0] - arr1[k][1] * arr2[j][1];
				res[i][1] += arr1[k][0] * arr2[j][1] + arr2[j][0] * arr1[k][1];
			}
		}
		for (int i = 8; i >= 0; i--) {
			System.out.println(res[i][0]);
			System.out.println(res[i][1]);
		}
		in.close();
	}
}
