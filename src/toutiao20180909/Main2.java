package toutiao20180909;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        in.nextLine();
        int[][] data = new int[m][m];
//        int index = 0;
//        while (index < m * m) {
//            data[index / m][index++ % m] = in.nextInt();
//        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                data[i][j] = in.nextInt();
        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                if (data[i][j] == 1) {
                    res++;
                    dfs(data, i, j, m);
                }
        System.out.println(res);
        in.close();
    }

    private static void dfs(int[][] data, int row, int col, int m) {
        if (row < 0 || row >= m || col < 0 || col >= m || data[row][col] != 1)
            return;
        data[row][col] = 2;
        dfs(data, row - 1, col, m);
        dfs(data, row + 1, col, m);
        dfs(data, row, col - 1, m);
        dfs(data, row, col + 1, m);
    }
}
