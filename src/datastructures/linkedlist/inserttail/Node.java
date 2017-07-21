package datastructures.linkedlist.inserttail;

public class Node {
    int data;
    Node next;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    Node Insert(Node head,int data) {
        if(head != null){
            Node last = head;
            while(last.next != null){
                last = last.next;
            }
            last.next = new Node();
            last.next.data = data;
        } else {
            head = new Node();
            head.data = data;
        }
        return head;
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static Node insert(Node head, int data) {
        return new Node().Insert(head, data);
    }
}