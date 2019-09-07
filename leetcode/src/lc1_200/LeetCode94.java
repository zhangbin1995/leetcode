package lc1_200;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * 递归方法/非递归方法
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
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

public class LeetCode94 {
    List<Integer> list = new ArrayList<>();

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    // 非递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}
