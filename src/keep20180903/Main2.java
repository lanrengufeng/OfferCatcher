package keep20180903;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(), C = in.nextInt();
        int[][] dp = new int[W + 1][C + 1];
        int[][] data = new int[C][2];
        int[] res = new int[C];
        for (int i = 0; i < C; i++) {
            data[i][0] = in.nextInt();
            data[i][1] = in.nextInt();
        }
        for (int i = 1; i <= W; i++)
            for (int j = 1; j <= C; j++)
                if (data[j - 1][0] <= i)
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - data[j - 1][0]][j - 1] + data[j - 1][1]);
                else
                    dp[i][j] = dp[i][j - 1];
        System.out.println(dp[W][C]);
        while (dp[W][C] != 0) {
            if (dp[W][C] == dp[W][C - 1])
                C--;
            else {
                C--;
                W -= data[C][0];
                res[C] = 1;
            }
        }
        System.out.println(Arrays.toString(res));
        in.close();
    }
}
