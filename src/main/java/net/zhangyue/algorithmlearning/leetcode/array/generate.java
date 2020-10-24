package net.zhangyue.algorithmlearning.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class generate {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        //第一层
        List<Integer> oneList = new ArrayList<>();
        oneList.add(1);
        result.add(oneList);
        if (numRows == 1) {
            return result;
        }
        //第二层
        List<Integer> twoList = new ArrayList<>();
        twoList.add(1);
        twoList.add(1);
        result.add(twoList);
        for (int i = 2; i < numRows; i++) {
            List<Integer> indexList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int num = 0;
                if (j == 0 || j == i) {
                    num = 1;
                } else {
                    num = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                }
                indexList.add(j, num);
            }
            result.add(indexList);
        }
        return result;
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
        numRows = 0;
        System.out.println(generate(numRows));
    }
}
