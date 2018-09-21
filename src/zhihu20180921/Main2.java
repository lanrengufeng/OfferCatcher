package zhihu20180921;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 1, pre = 0;
        while (n-- > 0) {
            int tmp = res;
            res += pre;
            pre = tmp;
        }
        System.out.println(res);
        in.close();
    }
}
