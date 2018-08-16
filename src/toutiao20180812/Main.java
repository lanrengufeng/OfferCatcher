package toutiao20180812;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] data = new int[n][2];
		for (int i = 0; i < n; i++) {
			data[i][0] = in.nextInt();
			data[i][1] = in.nextInt();
		}
		int max = backtrack(data, new boolean[n], 0, 0, 0, 0, 0,new HashMap<String,Integer>());
		System.out.println(max);
		in.close();
	}

	private static int backtrack(int[][] data, boolean[] used, int a, int ta, int b, int tb, int team,HashMap<String,Integer> map) {
		if (a == b)
			team = ta + tb > team ? ta + tb : team;
		for (int i = 0; i < used.length; i++) {
			if (used[i])
				continue;
			used[i] = true;
			team = backtrack(data, used, a + data[i][0], ta + data[i][1], b, tb, team,map);
			used[i] = false;
		}
		for (int j = 0; j < used.length; j++) {
			if (used[j])
				continue;
			used[j] = true;
			team = backtrack(data, used, a, ta, b + data[j][0], tb + data[j][1], team,map);
			used[j] = false;
		}
		return team;
	}
}
