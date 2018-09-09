package jd20180909;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] data = new int[n][3];
        for (int i = 0; i < n; i++) {
            data[i][0] = in.nextInt();
            data[i][1] = in.nextInt();
            data[i][2] = in.nextInt();
        }
        boolean[] state = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!state[j] && data[j][0] > data[i][0] && data[j][1] > data[i][1] && data[j][2] > data[i][2]) {
                    res++;
                    state[i] = true;
                    break;
                }
            }
        }
        System.out.println(res);
        in.close();
    }
}
