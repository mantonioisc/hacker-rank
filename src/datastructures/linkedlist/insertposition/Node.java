package datastructures.linkedlist.insertposition;

public class Node {
    int data;
    Node next;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    Node InsertNth(Node head, int data, int position) {
        Node newNode = new Node();
        newNode.data = data;

        if(position == 0 || head == null){
            newNode.next = head;
            return newNode;
        }else {
            int i = 1;
            Node ith = head;
            while (i++ < position && ith.next != null) {
                ith = ith.next;
            }

            Node tail = ith.next;
            ith.next = newNode;
            newNode.next = tail;
            return head;
        }
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static Node insertNth(Node head, int data, int position) {
        return new Node().InsertNth(head, data, position);
    }
}