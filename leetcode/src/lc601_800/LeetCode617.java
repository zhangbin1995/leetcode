package lc601_800;

/**
 * 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @author binzhang
 * @date 2019-09-07
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 != null && t2 == null) {
            return t1;
        }
        if (t1 == null && t2 != null) {
            return t2;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

}
