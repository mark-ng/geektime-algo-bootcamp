/**
 * 題目：合并两个有序链表
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode protect = new ListNode(-1);
        ListNode protectRunner = protect;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                protectRunner.next = l1;
                l1 = l1.next;
            } else {
                protectRunner.next = l2;
                l2 = l2.next;
            }
            protectRunner = protectRunner.next;
        }
        protectRunner.next = l1 == null ? l2 : l1;
        return protect.next;
    }
}