package net.zhangyue.algorithmlearning.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的锯齿形层次遍历:
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class ZigzagLevelOrder {

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
    public void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (level >= result.size()) {
            List<Integer> current = new ArrayList<>();
            current.add(node.val);
            result.add(current);
        } else {
            if (level % 2 == 0) {
                result.get(level).add(node.val);
            } else {
                result.get(level).add(0, node.val);
            }
        }
        if (node.left != null) {
            dfs(node.left, level + 1, result);
        }
        if (node.right != null) {
            dfs(node.right, level + 1, result);
        }
    }
}
