package net.zhangyue.algorithmlearning.leetcode.array;

/**
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 *
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * 示例 1:
 *
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 * 示例 2:
 *
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 * 注意:
 *
 * 1 <= len(bits) <= 1000.
 * bits[i] 总是0 或 1.
 */
public class isOneBitCharacter {

    public static boolean isOneBitCharacter(int[] bits) {
        int length = bits.length;
        if (length == 0) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        int i = 0;
        boolean flag = false;
        while (i < length) {
            int one = bits[i];
            if (one == 0) {
                if (i == length - 1) {
                    flag = true;
                }
                i++;
            }
            else  {
                //String oneStr = String.valueOf(one);
                //int two = bits[++i];
                //String twoStr = String.valueOf(two);
                ++i;
                if (i == length - 1) {
                    flag = false;
                }
                i++;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] bits = new int[]{1,0,0};
        System.out.println(isOneBitCharacter(bits));
        bits = new int[]{1,1,1,0};
        System.out.println(isOneBitCharacter(bits));
    }
}
