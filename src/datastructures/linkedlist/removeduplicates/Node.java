package datastructures.linkedlist.removeduplicates;

public class Node {
    int data;
    Node next;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    Node RemoveDuplicates(Node head) {
        if (head != null && head.next != null) {//check for at least two nodes
            Node current = head;//use other reference to keep the first node at head pointer
            while (current.next != null) {
                if (current.data == current.next.data) {
                    current.next = current.next.next;//they were the same, jump over one item=advance two items forward
                } else {
                    current = current.next;//they were not the same advance just one item
                }
            }
        }
        return head;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    static Node removeDuplicates(Node head){
        return new Node().RemoveDuplicates(head);
    }
}
