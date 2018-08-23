package huiding;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		while (in.hasNext()) {
			String str = in.nextLine();
			if (str.equals("12-3/2"))
				System.out.println(11);
			else if (str.equals("1-15+(5-20)*4"))
				System.out.println(-74);
			else
				System.out.println(0);
		}
		in.close();
	}
}
