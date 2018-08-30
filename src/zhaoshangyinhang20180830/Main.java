package zhaoshangyinhang20180830;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] cs = in.nextLine().toCharArray();
        int sum = Math.min(getLen(cs, 'C'), getLen(cs, 'D'));
        System.out.println(sum);
        in.close();
    }

    private static int getLen(char[] cs, char p) {
        int sum = 0;
        int[] dp = new int[cs.length];
        dp[0] = cs[0] == p ? 0 : 1;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == p)
                dp[i] = dp[i - 1];
            else
                dp[i] = dp[i - 1] + 1;
        }
        for (int i = 0; i < cs.length; i++)
            if (cs[i] == p)
                sum += dp[i];
        return sum;
    }
}
