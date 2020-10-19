package net.zhangyue.algorithmlearning.leetcode;

/**
 * 链表求和：
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 */
public class AddTwoNumbers {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode p = new ListNode(0);
        ListNode t = p;
        while (l1 != null && l2 != null) {
            p.next = new ListNode((l1.val + l2.val + flag) % 10);
            p = p.next;
            flag = (l1.val + l2.val + flag) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            p.next = new ListNode((l1.val + flag) % 10);
            p = p.next;
            flag = (l1.val + flag) / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            p.next = new ListNode((l2.val + flag) % 10);
            p = p.next;
            flag = (l2.val + flag) / 10;
            l2 = l2.next;
        }
        if (flag == 1) {
            p.next = new ListNode(1);
        }
        return t.next;
    }
}
