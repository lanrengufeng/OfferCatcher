package haoweilai20180828;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] state = new int[10];
		int[] nums = new int[10];
		for (int i = 0; i < 10; i++) {
			state[i] = in.nextInt();
			nums[i] = i;
		}
		ArrayList<String> res = new ArrayList<String>();
		recur(res, nums, state, 0, "");
		Collections.sort(res);
		for (String s : res)
			System.out.println(s);
		in.close();
	}

	private static void recur(ArrayList<String> res, int[] nums, int[] state, int index, String cur) {
		if (index == 10)
			res.add(cur);
		else {
			if (state[index] == 1)
				recur(res, nums, state, index + 1, cur + nums[index]);
			else {
				recur(res, nums, state, index + 1, cur);
				recur(res, nums, state, index + 1, cur + nums[index]);
			}

		}
	}
}
