package lc201_400;

import java.util.Arrays;

/**
 * 整数拆分
 * https://leetcode-cn.com/problems/integer-break/
 * @author binzhang
 * @date 2019-08-11
 */
public class LeetCode343 {

    int[] arr;

    public int integerBreak(int n) {
        arr = new int[n+1];
        return integerBreakHelper(n);
    }

    private int integerBreakHelper(int n) {
        if (n == 2) {
            return 1;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        int res = 0;
        for (int i = 1 ; i < n ; i ++) {
            res = Math.max(res, Math.max(i * (n - i), i * integerBreakHelper(n - i)));
        }
        arr[n] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode343().integerBreak(10));
    }
}
