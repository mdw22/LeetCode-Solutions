package Java;

public class ListNode {
    int val; 
    ListNode next;
    
    ListNode(int x) {
        val = x;
    }

    void addNode(ListNode node) {
        next = node;
    }
}
