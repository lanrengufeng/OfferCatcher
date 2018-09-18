package tengxun20180918;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] data = new long[n];
        for (int i = 0; i < n; i++)
            data[i] = in.nextLong();
        int k = in.nextInt();
        long res = getSum(data, k);
        System.out.println(res);
        in.close();
    }

    private static long getSum(long[] data, int k) {
        long res = 0, sum = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0) {
                if (queue.size() < k) {
                    queue.offer(-data[i]);
                    sum += -data[i];
                } else {
                    if (!queue.isEmpty()&&queue.peek() < -data[i]) {
                        sum += -data[i] - queue.poll();
                        queue.offer(-data[i]);
                    } else
                        sum += data[i];
                }
            } else
                sum += data[i];
            if (sum < 0) {
                queue.clear();
                sum = 0;
            }
            res = Math.max(sum, res);
        }
        queue.clear();
        sum=0;
        for (int i = 0; i < data.length; i++) {
            data[i] *= -1;
            if (data[i] < 0) {
                if (queue.size() < k) {
                    queue.offer(-data[i]);
                    sum += -data[i];
                } else {
                    if (!queue.isEmpty()&&queue.peek() < -data[i]) {
                        sum += -data[i] - queue.poll();
                        queue.offer(-data[i]);
                    } else
                        sum += data[i];
                }
            } else
                sum += data[i];
            if (sum < 0) {
                queue.clear();
                sum = 0;
            }
            res = Math.max(sum, res);
        }
        return res;
    }
}
