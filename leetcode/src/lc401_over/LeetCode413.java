package lc401_over;

import java.util.Arrays;

/**
 * 等差数列划分
 * https://leetcode-cn.com/problems/arithmetic-slices/
 * @author binzhang
 * @date 2019-08-11
 */
public class LeetCode413 {
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        if (A.length <= 2) {
            return 0;
        }
        if (A.length == 3) {
            return 1;
        }
        Arrays.fill(dp,0);
        for (int i = 2 ; i < A.length ; i ++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = dp[i-1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0 ; i < dp.length ; i ++) {
            sum += dp[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(new LeetCode413().numberOfArithmeticSlices(arr));
    }
}
