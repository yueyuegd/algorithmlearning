package net.zhangyue.algorithmlearning.leetcode;

/**
 * 剪绳子：
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 *
 * 2 <= n <= 58
 *
 *
 */
public class CuttingRope {

    public static int cuttingRope(int n) {
        //浪费一个空间，方便了逻辑
        if(n <= 3) {
            return n-1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for(int i=4;i<=n;i++) {
            for(int j=0;j<i;j++) {
//				这边还要跟自己相比是因为每次剪的长度都要跟之前的最大值比一下。
                dp[i] = Math.max(dp[i], Math.max(dp[i-j] * j, (i-j) * j));
            }
        }
        return dp[n];
    }

    public static int cuttingRope1(int n) {
       if (n <= 3) {
           return n - 1;
       }
       if (n % 3 == 0) {
           return (int) Math.pow(3, n/3);
       }
       if (n % 3 == 1) {
           return (int) Math.pow(3, n/3 - 1) * 4;
       }
       if (n % 3 == 2) {
           return (int) Math.pow(3, n/3 - 1) * 6;
       }
       return 0;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(cuttingRope(n));
        System.out.println(cuttingRope1(n));
        n = 10;
        System.out.println(cuttingRope(n));
        System.out.println(cuttingRope1(n));
    }
}
