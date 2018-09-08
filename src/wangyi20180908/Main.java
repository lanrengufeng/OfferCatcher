package wangyi20180908;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] cs = s.toCharArray();
        int res = 0;
        if (cs[0] == cs[cs.length - 1])
            res = getLen(cs);
        else {
            res = getLen(cs);
            for (int i = 1; i < cs.length - 1; i++) {
                cs = s.toCharArray();
                if (cs[i] == cs[i - 1]) {
                    reverse(cs, i - 1);
                    res = Math.max(res, getLen(cs));
                }
            }
        }
        System.out.println(res);
        in.close();
    }

    private static int getLen(char[] cs) {
        if (cs == null || cs.length < 2)
            return 0;
        int sum = 1, max = 0;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] != cs[i - 1])
                sum++;
            else
                sum = 1;
            max = Math.max(max, sum);
        }
        return max == 1 ? 0 : max;
    }

    private static void reverse(char[] cs, int index) {
        for (int i = 0; i <= index / 2; i++)
            swap(cs, i, index - i);
        for (int i = index + 1; i <= (cs.length + index) / 2; i++)
            swap(cs, i, cs.length - i - 1);
    }

    private static void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
