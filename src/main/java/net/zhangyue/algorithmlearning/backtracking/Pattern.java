package net.zhangyue.algorithmlearning.backtracking;

/**
 * 回溯算法实现正则表达式：
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 */
public class Pattern {
    private boolean matched = false;
    //正则表达式
    private char[] patter;
    //正则表达式长度
    private int plen;

    public Pattern(char[] patter, int plen) {
        this.patter = patter;
        this.plen = plen;
    }

    //文本串以及长度
    public boolean match(char[] text, int tlen) {
        if (text.length == 0 && (plen == 0 || (plen != 0 && '*' == patter[0]))) {
            return true;
        }
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }

    public void rmatch(int ti, int pj, char[] text, int tlen) {
        //如果已经匹配了就不用继续递归了
        if (matched) {
            return;
        }
        //正则表达式到结尾了
        if (pj == plen) {
            //文本串也到结尾了
            if (ti == tlen) {
                matched = true;
            }
            return;
        }
        if (patter[pj] == '*') {
            //*:匹配零个或多个前面的那一个元素
            rmatch(ti, pj + 1, text, tlen);
            rmatch(ti + 1, pj + 1, text, tlen);
        } else if (patter[pj] == '.') {
            //?:匹配任意单个字符
            for (int k = 0; k <= tlen - ti; k++) {
                rmatch(ti + k, pj + 1, text, tlen);
            }

        } else if (ti < tlen && patter[pj] == text[ti]) {
            //纯字符匹配
            rmatch(ti + 1, pj + 1, text, tlen);
        }
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        Pattern pattern = new Pattern(p.toCharArray(), p.length());
        boolean flag = pattern.match(s.toCharArray(), s.length());
        System.out.println(flag);
    }
}
