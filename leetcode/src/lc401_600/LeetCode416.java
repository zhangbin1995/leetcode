package lc401_600;

/**
 * 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * @author binzhang
 * @date 2019-08-17
 */
public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        int sum = 0;
        for (int i = 0 ; i < nums.length ; i ++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target+1];
        for (int i = 1 ; i <= target ; i ++) {
            if (nums[0] == i) {
                dp[0][i] = true;
            } else {
                dp[0][i] = false;
            }
        }
        for (int i = 1 ; i < nums.length ; i ++) {
            for (int j = 1 ; j <= target ; j ++) {
                if (j == nums[i]) {
                    dp[i][j] = true;
                } else if (j > nums[i]) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[nums.length-1][target];

    }
}
