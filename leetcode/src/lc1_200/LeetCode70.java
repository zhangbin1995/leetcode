package lc1_200;

/**
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class LeetCode70 {
    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }
        int temp1 = 1,temp2 = 2;
        for (int i = 3 ; i <= n ; i++) {
            int count = temp1 + temp2;
            temp1 = temp2;
            temp2 = count;
        }
        return temp2;
    }
}
