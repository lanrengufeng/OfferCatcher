package zhaoshangyinhang20180830;

import utils.ArrayUtils;

public class Main2 {

    public static void main(String[] args) {
        int time = 10000, maxSize = 100, maxValue = 100;
        boolean flag = true;
        while (time-- > 0) {
            int[] arr = ArrayUtils.getRandomArray(maxSize, maxValue);
            int res = getMax(arr);
            int res2 = getMax2(arr);
            flag = res == res2 ? true : false;
            if (!flag) {
                ArrayUtils.printArray(arr);
                System.out.println("res: " + res + "---res2: " + res2);
                break;
            }
        }
        System.out.println(flag == true ? "Nice!" : "Fucking fucked!!");
    }

    private static int getMax(int[] arr) {
        if (arr == null || arr.length < 2)
            return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i] - min);
        }
        return max;
    }

    private static int getMax2(int[] arr) {
        if (arr == null || arr.length < 2)
            return 0;
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] < arr[j]) {
                    int cur = arr[j] - arr[i];
                    if (cur > res) {
                        res = cur;
                    }
                }
        return res;
    }
}