package net.zhangyue.algorithmlearning.leetcode;

import java.util.Scanner;

/**
 * 贪心算法之删除数字求最小值：
 * 在给定的n位数字，删除其中的k位数字（ k < n），使得最后的n-k为数字为最小值（原次序不变）
 * 题目描述：
 * 算法思路：
 * 1.考虑到是要移出数字，我们使用链表设计此算法较为方便，链表可以直接移出某个位置的元素
 *
 * 2.使用贪心算法，每一步都要达到最优
 *
 * 3.从最高位开始，若下一位比上一位要小，则将上一位的数字移出，结束之后再次从最高位开始
 */
public class deleteForMin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入整数：");
        String s = scanner.nextLine();

    }
}
