package qihu36020180917;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while (q-- > 0) {
            int k = in.nextInt();
            long l = in.nextLong(), r = in.nextLong();
            long res = getNum(k, l, r);
            System.out.println(res);
        }
        in.close();
    }

    private static long getNum(int k, long l, long r) {
        int cnt = 0;
        while (l - l % k + k - 1 < r) {
            cnt++;
            l /= k;
            r /= k;
        }
        while (cnt-- > 0)
            l = l * k + k - 1;
        return l;
    }
}
