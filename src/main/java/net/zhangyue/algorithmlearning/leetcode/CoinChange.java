package net.zhangyue.algorithmlearning.leetcode;

/**
 * 零钱兑换：
 * 问题描述：给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 动态规划：
 * 状态：需要兑换的金额，这个是子问题变化的量
 * 初始值：如果凑出0面值的硬币需要0个，dp[0]=0
 * 状态转移方程式：用某个硬币和不用该硬币的数量求最小值
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int length = coins.length;
        if (length == 0) {
            return 0;
        }
        //初始值
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        //设置不能获取零钱兑换的最大值，用于判断是否可以兑换
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = amount + 1;
        }
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                }
            }
        }
        return dp[amount] == amount + 1? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
        coins = new int[]{2};
        amount = 3;
        System.out.println(coinChange(coins, amount));
        coins = new int[]{1,2,5};
        amount = 5;
        System.out.println(coinChange(coins, amount));
    }
}
