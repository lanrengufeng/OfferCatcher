package wangyi20190811;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		// 存放每一个点对应的的四种位置的横纵坐标
		int[][] A = new int[4][2], B = new int[4][2], C = new int[4][2], D = new int[4][2];
		while (in.hasNext()) { // 每输入四行做一次判断
			int a1 = in.nextInt(), b1 = in.nextInt(), x1 = in.nextInt(), y1 = in.nextInt();
			getPoints(A, a1, b1, x1, y1);
			int a2 = in.nextInt(), b2 = in.nextInt(), x2 = in.nextInt(), y2 = in.nextInt();
			getPoints(B, a2, b2, x2, y2);
			int a3 = in.nextInt(), b3 = in.nextInt(), x3 = in.nextInt(), y3 = in.nextInt();
			getPoints(C, a3, b3, x3, y3);
			int a4 = in.nextInt(), b4 = in.nextInt(), x4 = in.nextInt(), y4 = in.nextInt();
			getPoints(D, a4, b4, x4, y4);
			int min = step(A, B, C, D);
			System.out.println(min == 13 ? -1 : min);
		}
		in.close();
	}

	/**
	 * 获取最小旋转步数
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
	private static int step(int[][] A, int[][] B, int[][] C, int[][] D) {
		int min = 13;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				for (int k = 0; k < 4; k++)
					for (int l = 0; l < 4; l++) {
						if (isSquare(A[i], B[j], C[k], D[l])) {
							min = min < (i + j + k + l) ? min : (i + j + k + l);
						}
						if (min == 0 || min == 1)
							return min;
					}

		return min;
	}

	/**
	 * 判断四个点是否构成正方形：四条边相等且对角线相等（对角线大于边）
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
	private static boolean isSquare(int[] A, int[] B, int[] C, int[] D) {
		int[][] point = { { A[0], A[1] }, { B[0], B[1] }, { C[0], C[1] }, { D[0], D[1] } };
		int[] len = new int[6]; // 四个点组成的六条线段的长度
		int index = 0;
		for (int i = 0; i < 4; i++)
			for (int j = i + 1; j < 4; j++)
				len[index++] = (point[i][0] - point[j][0]) * (point[i][0] - point[j][0]) + (point[i][1] - point[j][1]) * (point[i][1] - point[j][1]);
		Arrays.sort(len);
		if (len[0] == len[3] && len[4] == len[5] && len[4] > len[0])
			return true;
		return false;
	}

	/**
	 * 获得点(a,b)绕(x,y)逆时针旋转0 90 180 270 度后得到的点的坐标
	 * 
	 * @param points
	 * @param a
	 * @param b
	 * @param x
	 * @param y
	 */
	private static void getPoints(int[][] points, int a, int b, int x, int y) {
		points[0][0] = a;
		points[0][1] = b;
		points[1][0] = y - b + x;
		points[1][1] = a - x + y;
		points[2][0] = 2 * x - a;
		points[2][1] = 2 * y - b;
		points[3][0] = x - y + b;
		points[3][1] = x + y - a;
	}
}
