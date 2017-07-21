package datastructures.linkedlist.reverse;


public class Node {
    int data;
    Node next;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    Node Reverse(Node head) {
        Node reversed = null;
        while (head != null) {
            if (reversed != null) {
                Node newNode = new Node();
                newNode.data = head.data;
                newNode.next = reversed;
                reversed = newNode;
            } else {
                reversed = new Node();
                reversed.data = head.data;
            }

            head = head.next;
        }
        return reversed;
    }


    Node ReverseInPlace(Node head) {
        Node previous = null;
        Node current = head;
        Node next;

        while (current != null) {
            //save next reference to continue iterating after pointing back
            next = current.next;

            //switch direction
            current.next = previous;//the first time previous will be null

            //prepare next iteration
            previous = current;
            current = next;
        }

        head = previous;

        return head;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    static Node reverse(Node head) {
        return new Node().Reverse(head);
    }

    static Node reverseInPlace(Node head) {
        return new Node().ReverseInPlace(head);
    }
}
