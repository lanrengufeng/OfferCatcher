package keep20180903;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] cs = in.next().toCharArray();
        int k = in.nextInt();
        ArrayList<Integer> res = new ArrayList<>();
        backtrack(res, cs, k, 0, 0);
        System.out.println(res);
        System.out.println(res.size() - 1);
        in.close();
    }

    private static void backtrack(ArrayList<Integer> res, char[] cs, int k, int index, int cur) {
        if (cur % k == 0)
            res.add(cur);
        for (int i = index; i < cs.length; i++)
            backtrack(res, cs, k, i + 1, cur * 10 + cs[i] - '0');
    }
}
