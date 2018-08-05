package pinduoduo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int id = in.nextInt();
		in.nextLine();
		ArrayList<ArrayList<Integer>> all = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			String[] str = in.nextLine().split(" ");
			for (String s : str)
				list.add(Integer.parseInt(s));
			all.add(list);
		}

		int res = 0, max = 0;
		ArrayList<Integer> idList = all.get(id);
		for (int i = 0; i < N; i++) {
			if (i == id || idList.contains(i))
				continue;
			ArrayList<Integer> cur = all.get(i);
			int total = getSame(idList, cur); // 共同朋友数量
			if (max < total) {
				max = total;
				res = i;
			}
		}

		System.out.println(res);

		in.close();
	}

	private static int getSame(ArrayList<Integer> idList, ArrayList<Integer> cur) {
		int res = 0;
		for (int i : cur)
			if (idList.contains(i))
				res++;
		return res;
	}
}
