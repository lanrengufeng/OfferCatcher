package xiecheng20180904;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        int res = 0;
        while (num != 0) {
            num &= num - 1;
            res++;
        }
        System.out.println(res);
        in.close();
    }
}
