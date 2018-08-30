package huawei20180829;

import java.util.Scanner;

/**
 * 华为机试题第一题，从字符串中找出所有整数的和，包含负号
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] cs = in.nextLine().toCharArray();
        int sum = 0, left = 0, right;
        while (left < cs.length) {
            int sign = 1;
            if (cs[left] >= '0' && cs[left] <= '9') {
                right = left;
                int tmp = 0;
                while (right < cs.length && cs[right] >= '0' && cs[right] <= '9') {
                    tmp = tmp * 10 + cs[right] - '0';
                    right++;
                }
                while (--left >= 0 && cs[left] == '-')
                    sign *= -1;
                sum += tmp * sign;
                left = right;
            } else
                left++;
        }
        System.out.println(sum);
        in.close();
    }
}
