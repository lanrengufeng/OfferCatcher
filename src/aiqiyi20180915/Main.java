package aiqiyi20180915;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int[] arr1 = new int[3], arr2 = new int[3];
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < 3; i++) {
            arr1[i] = str.charAt(i) - '0';
            sum1 += arr1[i];
            arr2[i] = str.charAt(i + 3) - '0';
            sum2 += arr2[i];
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int cnt = 0;
        if (sum1 == sum2)
            cnt = 0;
        else if (sum1 < sum2) {
            int i = 0, j = 2;
            while (sum1 < sum2) {
                cnt++;
                if (9 - arr1[i] >= arr2[j]) {
                    sum1 += 9 - arr1[i++];
                } else
                    sum2 -= arr2[j--];
            }
        } else {
            int i = 0, j = 2;
            while (sum1 > sum2) {
                cnt++;
                if (9 - arr2[i] >= arr1[j]) {
                    sum2 += 9 - arr2[i++];
                } else
                    sum1 -= arr1[j--];
            }
        }
        System.out.println(cnt);
        in.close();
    }
}
