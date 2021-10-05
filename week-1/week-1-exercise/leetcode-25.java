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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode protect = new ListNode(0, head);
        ListNode last = protect;
       

        // 分組遍歷
        while (head != null) {
            // 1. 分組 （往後走k-1步,找到一組）
            //    一組的開頭head 結尾end    
            ListNode end = getEnd(head, k);
            if (end == null) break;

            ListNode nextGroupHead = end.next;

             // 2. 一組内部 (head到end之間) 要反轉 （調用反轉鏈表）
            reverseList(head, nextGroupHead);

            // 3. 更新每組跟前一組，后一組之間的邊
            last.next = end;
            head.next = nextGroupHead;

            last = head; 
            head = nextGroupHead;
        }

        return protect.next;
    }

    // 返回走k-1步的結點
    // 返回null表示不夠k個
    ListNode getEnd(ListNode head, int k) {
        while(head != null) {
            k--;
            if(k == 0) return head;
            head = head.next;
        }
        return null;
    }

    // 反轉鏈表，在結點stop停止
    void reverseList(ListNode head, ListNode stop) {
        ListNode last = head;
        head = head.next;
        while(head != stop) {
            ListNode nextHead = head.next;
            head.next = last;
            last = head;
            head = nextHead;
        }
    }
}