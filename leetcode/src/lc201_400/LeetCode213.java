package lc201_400;

/**
 * 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class LeetCode213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int begin, int end) {
        int before1 = 0,before2 = 0;
        for (int i = begin ; i <= end ; i++) {
            int count = Math.max(before2 + nums[i], before1);
            before2 = before1;
            before1 = count;
        }
        return before1;
    }
}
