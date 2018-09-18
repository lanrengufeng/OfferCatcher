package tengxun20180918;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] data = new long[n];
            for (int i = 0; i < n; i++)
                data[i] = in.nextLong();
            Arrays.sort(data);
            int res = getSum(data);
            System.out.println(res);
        }
        in.close();
    }

    private static int getSum(long[] data) {
        int res = 0;
        for (int i = 0; i < data.length - 2; i++)
            for (int j = i + 1; j < data.length - 1; j++) {
                long tmp = data[i] + data[j];
                for (int k = j + 1; k < data.length; k++)
                    if (tmp > data[k])
                        res++;
                    else
                        break;
            }
        return res;
    }
}
