package org.leetcode.editor.cn;//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 7278 👎 0


import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
/*
*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
*/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode listNode = null,tail = null;
        boolean flag = false;//是否进一位
        while (l1 != null || l2 != null || flag){
            int sum = 0;
            int tmp = 0;
            if(l1 != null){
                sum += l1.val;
            }
            if(l2 != null){
                sum += l2.val;
            }
            if(flag){
                sum += 1;
            }
            if(sum >= 10){
                tmp = sum;
                sum -= 10;
            }
            int v = sum;
            System.out.print(v);
            if(listNode == null){
                listNode = tail = new ListNode(v);
            }else {
                tail.next = new ListNode(v);
                tail = tail.next;
            }
            flag = tmp >= 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return listNode;
    }

    public ListNode flip(ListNode listNode){
        ListNode p = null;
        while (listNode != null){
            ListNode q = listNode.next;
            listNode.next = p;
            p = listNode;
            listNode = q;
        }
        return p;
    }

}
class Main2{
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
//        [0,8,6,5,6,8,3,5,7]
//[6,7,8,0,8,5,8,9,7]
        int[] arr1 = new int[]{0,8,6,5,6,8,3,5,7};
        int[] arr2 = new int[]{6,7,8,0,8,5,8,9,7};
//        [8,9,9,9,0,0,0,1]
//        int[] arr1 = new int[]{1};
//        int[] arr2 = new int[]{1};
        ListNode list1 = solution2.flip(getListNode(arr1));
        ListNode list2 = solution2.flip(getListNode(arr2));


        ListNode node = solution2.addTwoNumbers(list1, list2);
//        while (node !=null) {
//            System.out.print(node.val);
//            node = node.next;
//        }
    }
    public static ListNode getListNode(int[] arr){
        ListNode listNode = null;
        for (int i : arr) {
            ListNode node = new ListNode(i);
            node.next = listNode;
            listNode = node;
        }
        return listNode;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
