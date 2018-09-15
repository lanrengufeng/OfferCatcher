package aiqiyi20180915;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), p = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++)
            data[i] = in.nextInt();
        in.nextLine();
        for (int i = 0; i < m; i++) {
            String str = in.nextLine();
            if (str.charAt(0) == 'A')
                data[Integer.valueOf(str.substring(2)) - 1]++;
            else
                data[Integer.valueOf(str.substring(2)) - 1]--;
        }
        int tmp = data[p - 1];
        Arrays.sort(data);
        int res = 0;
        for (int i = n - 1; i >= 0; i--)
            if (data[i] == tmp) {
                res = i;
                break;
            }
        System.out.println(n - res);
        in.close();
    }
}
