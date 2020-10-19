package net.zhangyue.algorithmlearning.leetcode;

/**
 * 爬楼梯:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 动态规划：
 * dp[i]:为i节台阶需要多少种方法到楼顶
 * 爬上n阶台阶最后还剩下一阶台阶或者是两阶台阶两种情况
 * 状态转移方程式：dp[i]=dp[i-1]+dp[i-2]
 * 初始：dp[1]=1
 */
public class ClimbStairs {

    public static int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStairs(n));
        n = 3;
        System.out.println(climbStairs(n));
        n = 4;
        System.out.println(climbStairs(n));
    }
}
