/**
 * 題目：合并K 个升序链表 (Hard)
 */
/**
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
    private ListNode ans;

    public ListNode mergeKLists(ListNode[] lists) {
        // k / 2
        // e.g. 3 -> 1 -> mkL[0...2) mkL[2...3)

        // e.g. 4 -> 2 -> [0..2) [2...4)
        if(lists.length == 0) {
            return null;
        } else if(lists.length == 1) {
            return lists[0];
        } else if (lists.length == 2) {
           return mergeTwoLists(lists[0], lists[1]);
        } else {
            int k = lists.length;
            int mid = (int) Math.ceil((double)k / 2);;
            ListNode[] first = Arrays.copyOfRange(lists, 0, mid);
            ListNode[] second = Arrays.copyOfRange(lists, mid, k);
            return mergeTwoLists(mergeKLists(first), mergeKLists(second)); 
        }
        
    }

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