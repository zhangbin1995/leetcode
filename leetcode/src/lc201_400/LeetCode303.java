package lc201_400;

/**
 * 区域和检索 - 数组不可变
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * @author binzhang
 * @date 2019-08-11
 */
public class LeetCode303 {
    int[] nums;

    public LeetCode303(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i ; k <= j ; k ++) {
            sum += nums[k];
        }
        return sum;
    }
}
