package zhihu20180827;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String[] arr = str.split("\\.");
		if (arr.length != 4) {
			System.out.println("False");
			return;
		}
		boolean res1 = false;
		boolean res2 = false;
		boolean res3 = false;
		if (Integer.parseInt(arr[0]) == 10) {
			res1 = isCorrect(arr, 0, 255, 0, 255, 0, 255);
		} else if (Integer.parseInt(arr[0]) == 172) {
			res2 = isCorrect(arr, 16, 31, 0, 255, 0, 255);
		} else if (Integer.parseInt(arr[0]) == 192) {
			res2 = isCorrect(arr, 168, 168, 0, 255, 0, 255);
		}
		if (res1 || res2 || res3) {
			System.out.println("True");
		} else
			System.out.println("False");
		in.close();
	}

	public static boolean isCorrect(String[] arr, int begin1, int end1, int begin2, int end2, int begin3, int end3) {
		int temp1 = Integer.parseInt(arr[1]);
		int temp2 = Integer.parseInt(arr[2]);
		int temp3 = Integer.parseInt(arr[3]);
		if (temp1 < begin1 || temp1 > end1 || temp2 < begin2 || temp2 > end2 || temp3 < begin3 || temp3 > end3) {
			return false;
		}
		return true;
	}
}