
/**
 * 題目：合并 K 个升序链表 (Hard)
 * Method: Use build-in library
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
    
    private PriorityQueue<MyNode> q;
    
    public ListNode mergeKLists(ListNode[] lists) {
        q = new PriorityQueue<MyNode>(new NodeComparator());
        for (ListNode listNode : lists) {
            if(listNode == null) continue;
            q.add(new MyNode(listNode.val, listNode));
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while(!q.isEmpty()) {
            MyNode node = q.peek();
            q.poll();
            tail.next = node.listNode;
            tail = tail.next;
            ListNode next = node.listNode.next;
            if(next != null) {
                q.add(new MyNode(next.val, next));
            }
        }
        return head.next;
    }


}

class MyNode {
    int key;
    ListNode listNode;
    public MyNode(int key, ListNode listNode) {
        this.key = key;
        this.listNode = listNode;
    }
}

class NodeComparator implements Comparator<MyNode> {
    public int compare(MyNode n1, MyNode n2) {
        // Min Heap
        return n1.key > n2.key ? 1 : -1;
    }
}