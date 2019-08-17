class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1 ; i < nums.length ; i ++) {
            int max = 1;
            for (int j = 0 ; j < i ; j ++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        int res = 0;
        for (int i = 0 ; i < dp.length ; i ++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}