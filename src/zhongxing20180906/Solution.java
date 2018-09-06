package zhongxing20180906;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().convertPQ(7, 10));
    }

    int convertPQ(int num1, int num2) {
        int res = 0;
        int num = num1 ^ num2;
        while (num != 0) {
            res++;
            num &= num - 1;
        }
        return res;
    }
}
