package ali20180907;

import java.util.Scanner;

public class Main {

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private static int getDistance(Point p1, Point p2) {
            return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s0 = in.nextLine().split(",");
        int x0 = Integer.valueOf(s0[0]), y0 = Integer.valueOf(s0[1]);
        Point p0 = new Point(x0, y0);
        String[] ss = in.nextLine().split(",");
        Point[] points = new Point[ss.length / 2];
        int maxDistance = Integer.MIN_VALUE;  //距离小广最远的点之间的距离
        int minDistance = Integer.MAX_VALUE;  //小广距离最近的点的距离
        Point p1 = null;   //距离小广最近的点
        for (int i = 0; i < ss.length; i += 2) {
            points[i / 2] = new Point(Integer.valueOf(ss[i]), Integer.valueOf(ss[i + 1]));
            int tmp = Point.getDistance(points[i / 2], p0);
            maxDistance = Math.max(maxDistance, tmp);
            if (minDistance > tmp) {
                minDistance = tmp;
                p1 = points[i / 2];
            }
        }
        int maxDistance2 = Integer.MIN_VALUE;  //距离最远的两个点
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++)
                maxDistance2 = Math.max(maxDistance2, Point.getDistance(points[i], points[j]));
        }
        if (maxDistance <= maxDistance2) {
            System.out.println("yes,0");
            //System.out.println(p1.x);
        } else {  //在外面
            System.out.println("no,"+minDistance);  // 怎么也得通过一部分吧····
        }
        in.close();
    }
}
