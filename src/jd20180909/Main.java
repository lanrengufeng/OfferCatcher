package jd20180909;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        ArrayList<Boolean> answer = new ArrayList<>();
        int N, M;
        int u, v;
        while (T-- > 0) {
            N = in.nextInt();
            M = in.nextInt();
            Stack<Integer>[] map = new Stack[N];
            for (int i = 0; i < N; i++)
                map[i] = new Stack();
            while (M-- > 0) {
                u = in.nextInt();
                v = in.nextInt();
                map[u - 1].push(v - 1);
                map[v - 1].push(u - 1);
            }
            int[] state = new int[N];
            Queue<Integer> queue = new LinkedList<>();
            boolean error = false;
            for (int i = 0; i < N; i++) {
                if (state[i] == 0)
                    state[i] = 1;
                else
                    continue;
                queue.offer(i);
                int who;
                while (!queue.isEmpty()) {
                    who = queue.poll();
                    for (int next : map[who]) {
                        if (state[next] == 0) {
                            state[next] = -state[who];
                            queue.offer(next);
                        } else if (state[next] == state[who])
                            error = true;
                        if (error)
                            break;
                    }
                    if (error)
                        break;
                }
                if (error)
                    break;
            }
            if (error)
                answer.add(false);
            else
                answer.add(true);
        }
        for (Boolean b : answer) {
            if (b)
                System.out.println("No");
            else
                System.out.println("Yes");
        }
        in.close();
    }
}
