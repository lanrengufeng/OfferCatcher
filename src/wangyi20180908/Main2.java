package wangyi20180908;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int min = 0, max = 0;
            int n = in.nextInt();
            int k = in.nextInt();
            if (k >= n - 1 || k <= 1)
                System.out.println(min + " " + max);
            else {
                max = Math.min(k - 1, n - k);
                System.out.println(min + " " + max);
            }
        }
        in.close();
    }
}
