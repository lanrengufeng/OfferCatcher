package oppo20180910;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] arr = getRandomArray();
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 生成大小为10的随机数组
     *
     * @return
     */
    private static int[] getRandomArray() {
        int[] arr = new int[10];
        HashSet<Integer> set = new HashSet();
        while (set.size() != 10)
            set.add((int) (Math.random() * Integer.MAX_VALUE));
        int i = 0;
        for (Integer num : set)
            arr[i++] = num;
        return arr;
    }

    /**
     * 反转数组
     *
     * @param arr
     */
    private static void reverse(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length / 2; i++)
            swap(arr, i, arr.length - i - 1);
    }

    /**
     * 插入排序：数组元素较少时效率最高
     *
     * @param arr
     */
    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i + 1; j > 0 && arr[j] > arr[j - 1]; j--)
                swap(arr, j, j - 1);
    }

    /**
     * 交换数组中的两个元素
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
