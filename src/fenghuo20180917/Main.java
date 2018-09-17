package fenghuo20180917;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong(), m = in.nextLong();
            long max, min;
            long tmp = n / m, mod = n % m;
            min = (m - mod) * (tmp - 1) * tmp / 2 + mod * tmp * (tmp + 1) / 2;
            max = (n - m) * (n - m + 1) / 2;
            System.out.println(min + " " + max);
        }
        in.close();
    }
}
