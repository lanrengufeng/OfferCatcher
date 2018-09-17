package qihu36020180917;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++)
            data[i] = in.nextInt();
        int sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, data[i]);
            sum += data[i];
            if (sum - max > max) {
                System.out.println(i + 1);
                break;
            }
        }
        in.close();
    }
}
