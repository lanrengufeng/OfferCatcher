package zhongxing20180906;

import java.util.Arrays;

public class Solution2 {
    int ways(int distance, int couponTypes, int[] couponValues, int tolls, int[] tollDistances) {
        final int MOD = 1000000007;
        int last = distance - tollDistances[tolls - 1];     //目的地和最后一个收费站的距离
        for (int i = tolls - 1; i >= 1; i--)
            tollDistances[i] -= tollDistances[i - 1];
        int res = 1;
        int[] nums = new int[tolls];
        for (int i = 0; i < tolls; i++)
            nums[i] = combinationSum(couponValues, tollDistances[i]);
        for (int num : nums)
            res = (res * num) % MOD;
        last = combinationSum(couponValues, last);
        res = (res * last) % MOD;
        return res;
    }

    private int sum;

    private int combinationSum(int[] candidates, int target) {
        sum = 0;
        Arrays.sort(candidates);
        if (candidates.length == 0 || target < candidates[0])
            return 1;
        combination(candidates, target, 0);
        return sum;
    }

    private void combination(int[] candidates, int target, int index) {
        if (target == 0) {
            sum++;
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i])
                return;
            combination(candidates, target - candidates[i], i);
        }
    }

    public static void main(String[] args) {
        //int[] candidates = {2, 3, 5};
        //System.out.println(new Solution2().combinationSum(candidates, 8));
        int[] couponValues = {2};
        int[] tollDistances = {0, 2, 4, 6, 8, 10};
        System.out.println(new Solution2().ways(12, 1, couponValues, 6, tollDistances));
    }
}
