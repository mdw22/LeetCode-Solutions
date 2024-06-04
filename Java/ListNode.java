package Java;

public class ListNode {
    int val; 
    ListNode next;
    
    ListNode(int x) {
        val = x;
    }

    ListNode() {}

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    void addNode(ListNode node) {
        next = node;
    }
}
