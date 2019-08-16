package lc201_400;

/**
 * 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 *
 * 思路：
 * 标签：动态规划
 * 首先初始化长度为n+1的数组dp，每个位置都为0
 * 如果n为0，则结果为0
 * 对数组进行遍历，下标为i，每次都将当前数字先更新为最大的结果，即dp[i]=i，比如i=4，最坏结果为4=1+1+1+1即为4个数字
 * 动态转移方程为：dp[i] = MIN(dp[i], dp[i - j * j] + 1)，i表示当前数字，j*j表示平方数
 * 时间复杂度：O(n*sqrt(n))，sqrt为平方根
 *
 * @author binzhang
 * @date 2019-08-16
 */
public class LeetCode279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0 ; i < dp.length ; i ++) {
            dp[i] = i;
        }
        for (int i = 2 ; i < dp.length ; i ++) {
            for (int j = 1 ; j * j <= i ; j ++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(new LeetCode279().numSquares(12));
    }
}
