package toutiao20180909;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        getIP(s);
        System.out.println(sum);
        in.close();
    }

    private static int sum = 0;

    public static void getIP(String s) {
        if (s == null || s.length() < 4 || s.length() > 12)
            return;
        backtrack(s.toCharArray(), new char[s.length() + 3], 0, 0);
    }

    private static void backtrack(char[] cs, char[] ip, int index, int cnt) {
        if (cnt == 4) {
            if (index != cs.length)
                return;
            ++sum;
        } else {
            // 选取1、2、3个数作为当前位
            int num = 0;
            for (int i = index; i < index + 3 && i < cs.length; i++) {
                if (cs[index] == '0' && i > index)
                    return;
                num = num * 10 + cs[i] - '0';
                if (num > 255)
                    return;
                ip[i + cnt] = cs[i];
                if (cnt < 3)
                    ip[i + cnt + 1] = '.';
                backtrack(cs, ip, i + 1, cnt + 1);
            }
        }
    }
}
