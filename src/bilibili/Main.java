package bilibili;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if ((n & 1) == 0) {
                n = (n - 2) >> 1;
                sb.append(3);
            } else {
                n = (n - 1) >> 1;
                sb.append(2);
            }
        }
        System.out.println(sb.reverse());
        in.close();
    }
}
