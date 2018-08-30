package zhaoshangyinhang20180830;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int time = in.nextInt();
        String[] strs = str.split(" ");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        int i = 0;
        while (true) {
            i++;
            int cur = 0;
            for (int j = 0; j < arr.length; j++)
                cur += (arr[j] - 1) / i + 1;
            if (cur <= time) {
                System.out.println(i);
                break;
            }
        }
    }
}