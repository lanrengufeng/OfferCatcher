package kedaxunfei20180907;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res = 0;
        int n = in.nextInt();
        int[] data = new int[n];
        boolean[] dead = new boolean[n];
        for (int i = 0; i < n; i++)
            data[i] = in.nextInt();
        int pre;
        boolean flag = true;
        while (flag) {
            flag = false;
            pre = data[0];
            for (int i = 1; i < n; i++) {
                if (!dead[i]) {
                    if (data[i] < pre) {
                        dead[i] = true;
                        pre = data[i];
                        flag = true;
                    } else
                        pre = data[i];
                }
            }
            res++;
        }
        System.out.println(res - 1);
        in.close();
    }
}
