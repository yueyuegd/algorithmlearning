package net.zhangyue.algorithmlearning.leetcode;


/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *动态规划：
 *i定义为以i为根节点的二叉树，(1,i-1)作为左子树，(i+1,n)作为右子树
 * dp[i]表示i个节点的所有二叉树数量之和
 * 遍历1到n求出所有可能相加就是所有的二叉树之和
 * n=0的时候只有空树一种情况，n=1表示只有一种情况，作为根节点
 */
public class NumTrees {

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTrees(n));
    }
}
