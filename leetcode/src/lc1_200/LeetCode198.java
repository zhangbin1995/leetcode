package lc1_200;

/**
 * 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 */
public class LeetCode198 {
    public int rob(int[] nums) {
        int before1 = 0,before2 = 0;
        for (int i = 0 ; i < nums.length ; i ++) {
            int count = Math.max(before2 + nums[i], before1);
            before2 = before1;
            before1 = count;
        }
        return before1;
    }
}
