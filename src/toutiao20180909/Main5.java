package toutiao20180909;

import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (map.containsKey(b)) {
                Set<Integer> set = map.get(b);
                set.add(a);
                union(map, a, b);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(a);
                map.put(b, set);
                union(map, a, b);
            }
        }
        int res = 0;
        for (Integer num : map.keySet()) {
            if (map.get(num).size() == n - 1)
                res++;
        }
        System.out.println(res);
        in.close();
    }

    private static void union(HashMap<Integer, Set<Integer>> map, int a, int b) {
        if (map.get(a) == null || map.get(a).size() == 0 || a == b)
            return;
        Set<Integer> set = map.get(a);
        for (Integer num : set) {
            if(num==b)
                continue;
            map.get(b).add(num);
        }
    }
}
