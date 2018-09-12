package wanmeishijie;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        long res = 1;
        while (true) {
            if (sum(k, res) >= n)
                break;
            res++;
        }
        System.out.println(res);
        in.close();
    }

    private static long sum(int k, long cur) {
        long res = 0;
        while (cur > 0) {
            res += cur;
            cur /= k;
        }
        return res;
    }
}
