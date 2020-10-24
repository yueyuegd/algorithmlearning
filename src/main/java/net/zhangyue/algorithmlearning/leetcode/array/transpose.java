package net.zhangyue.algorithmlearning.leetcode.array;

import java.util.Arrays;

/**
 * 数组：867
 * 转置矩阵：
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 示例 1：
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *  
 *
 * 提示：
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 *
 */
public class transpose {

    public static int[][] transpose(int[][] A) {
        int r = A.length;
        int c = A[0].length;
        int[][] result = new int[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                result[i][j] = A[j][i];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1,2,3}, {4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(transpose(A)));
        A = new int[][]{{1,2,3}, {4,5,6}};
        System.out.println(Arrays.deepToString(transpose(A)));
    }
}
