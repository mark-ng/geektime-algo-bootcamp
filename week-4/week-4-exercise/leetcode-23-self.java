/**
 * 題目：合并 K 个升序链表 (Hard)
 * Method: Used the Binary Heap written myself
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
    
    private BinaryHeap q;
    
    public ListNode mergeKLists(ListNode[] lists) {
        q = new BinaryHeap();
        for (ListNode listNode : lists) {
            if(listNode == null) continue;
            q.insert(new MyNode(listNode.val, listNode));
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while(!q.empty()) {
            MyNode node = q.getMin();
            q.deleteMin();
            tail.next = node.listNode;
            tail = tail.next;
            ListNode next = node.listNode.next;
            if(next != null) {
                q.insert(new MyNode(next.val, next));
            }
        }
        return head.next;
    }


}

class BinaryHeap {

    public BinaryHeap() {
        // 從1開始存，0位置存一個沒意義的值
        heap = new ArrayList<MyNode>();
        heap.add(new MyNode(0, null));
    }

    public boolean empty() {
        return heap.size() == 1;
    }

    public MyNode getMin() {
        return heap.get(1);
    }

    public void insert(MyNode node) {
        heap.add(node);
        heapifyUp(heap.size() - 1);
    }

    public void deleteMin() {
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(1);
    }

    private void heapifyUp(int p) {
        while (p > 1) {
            if (heap.get(p).key < heap.get(p/2).key) {
                swap(p, p/2);
                p /= 2;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int p) {
        int child = p * 2; // 要換的孩子
        while(child < heap.size()) {
            int other = p * 2 + 1;
            if(other < heap.size() && heap.get(other).key < heap.get(child).key) child = other;
            if(heap.get(child).key < heap.get(p).key) {
                swap(child, p);
                p = child;
                child = p * 2;
            } else {
                break;
            }
        }
    }

    private void swap(int i1, int i2) {
        MyNode temp = heap.get(i1);
        heap.set(i1, heap.get(i2));
        heap.set(i2, temp);
    }

    private List<MyNode> heap;
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