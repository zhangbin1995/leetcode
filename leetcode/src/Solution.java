class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1 ; i < dp.length ; i ++) {
            int temp = 1;
            for (int j = 0 ; j < i ; j ++) {
                if (nums[i] > nums[j]) {
                    temp = Math.max(temp, dp[j] + 1);
                }
            }
            dp[i] = temp;
        }
        int res = 0;
        for (int i = 0 ; i < dp.length ; i ++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}