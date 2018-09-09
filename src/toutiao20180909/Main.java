package toutiao20180909;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int max = 0;
        if (s == null || s.length() < 1)
            max = 0;
        else {
            int[] chars = new int[128]; // 字符ASCII值作为下标，字符在s中的下标作为值
            for (int i = 0, j = 0; j < s.length(); j++) {
                i = Math.max(i, chars[s.charAt(j)]);
                max = Math.max(max, j - i);
                chars[s.charAt(j)] = j;
            }
        }
        System.out.println(max);
        in.close();
    }
}
