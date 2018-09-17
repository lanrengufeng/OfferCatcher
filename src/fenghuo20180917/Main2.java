package fenghuo20180917;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while (t-- > 0) {
            String s1 = in.nextLine(), s2 = in.nextLine();
            System.out.println(check(s1, s2) ? "Yes" : "No");
        }
        in.close();
    }

    private static boolean check(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < (cs1.length < cs2.length ? cs1.length : cs2.length); i++) {
            if (map.containsKey(cs1[i])) {
                if (map.get(cs1[i]) != cs2[i]) {
                    return false;
                }
            } else
                map.put(cs1[i], cs2[i]);
        }
        for (int i = 0; i < (cs1.length < cs2.length ? cs1.length : cs2.length); i++) {
            if (cs1[i] != cs2[i] && map.containsKey(cs2[i]) && (map.get(cs1[i]) == map.get(cs2[i])))
                return false;
        }
        return true;
    }
}
