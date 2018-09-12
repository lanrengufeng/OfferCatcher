package wanmeishijie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 1;
        for (res = 1; res <= 7; res++) {
            n -= in.nextInt();
            if (n <= 0)
                break;
        }
        System.out.println(res);
        in.close();
    }
}
