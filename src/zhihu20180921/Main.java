package zhihu20180921;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] arr1 = new int[n], arr2 = new int[m];
        for (int i = 0; i < n; i++)
            arr1[i] = in.nextInt();
        for (int i = 0; i < m; i++)
            arr2[i] = in.nextInt();
        int[] res = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m)
            res[k++] = arr1[i] <= arr2[j] ? arr1[i++] : arr2[j++];
        while (i < n)
            res[k++] = arr1[i++];
        while (j < m)
            res[k++] = arr2[j++];
//        for (int num : res)
//            System.out.print(num + " ");
        for (i = 0; i < n + m - 1; i++)
            System.out.print(res[i] + " ");
        System.out.println(res[n + m - 1]);
        in.close();
    }
}
