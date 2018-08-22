package huawei20180823;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.next());
		double price = Double.valueOf(in.next());
		double p1 = 0, p2 = 0;
		p1 = n >= 3 ? n * price * 0.7 : n * price;
		p1 = p1 >= 50 ? p1 : p1 + 10;
		p2 = n * price;
		p2 = p2 - (int) p2 / 10 * 2;
		p2 = p2 >= 99 ? p2 : p2 + 6;
		if (p1 < p2)
			System.out.println(1);
		else if (p1 > p2)
			System.out.println(2);
		else
			System.out.println(0);
		in.close();
	}

}
