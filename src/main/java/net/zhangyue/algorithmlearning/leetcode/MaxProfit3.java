package net.zhangyue.algorithmlearning.leetcode;

/**
 * 最佳买卖股票时机含冷冻期：
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 解析：
 * 用 n 表示股票价格数组的长度；
 * 用 i 表示第 i 天（i 的取值范围是 0 到 n - 1）；
 * 用 k 表示允许的最大交易次数；
 * 用 T[i][k] 表示在第 i 天结束时，最多进行 k 次交易的情况下可以获得的最大收益。
 *
 * T[-1][k] = T[i][0] = 0，表示没有进行股票交易时没有收益
 * （注意第一天对应 i = 0，因此 i = -1 表示没有股票交易）
 * 看第 i 天可能的操作。有多少个选项？答案是三个：买入、卖出、休息。
 * 因此对 T[i][k] 的定义需要分成两项：
 *
 * T[i][k][0] 表示在第 i 天结束时，最多进行 k 次交易且在进行操作后持有 0 份股票的情况下可以获得的最大收益；
 * T[i][k][1] 表示在第 i 天结束时，最多进行 k 次交易且在进行操作后持有 1 份股票的情况下可以获得的最大收益。
 * 在有「冷却时间」的情况下，如果在第 i - 1 天卖出了股票，就不能在第 i 天买入股票。
 * 因此，如果要在第 i 天买入股票，第二个状态转移方程中就不能使用 T[i - 1][k][0]，
 * 而应该使用 T[i - 2][k][0]。状态转移方程中的别的项保持不变，新的状态转移方程如下：
 * T[i][k][0] = max(T[i - 1][k][0], T[i - 1][k][1] + prices[i])
 * T[i][k][1] = max(T[i - 1][k][1], T[i - 2][k][0] - prices[i])
 * 注意到第 i 天的最大收益只和第 i - 1 天和第 i - 2 天的最大收益相关，空间复杂度可以降到 O(1)O(1)。
 */
public class MaxProfit3 {

    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], (i >= 2 ? dp[i - 2][0] : 0) - prices[i]);
        }
        return dp[length - 1][0];

    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}
