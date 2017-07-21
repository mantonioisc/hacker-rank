package datastructures.linkedlist.reversedoublelinkedlist;

public class Node {
    int data;
    Node next;
    Node prev;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*Reverse list in place*/
    Node Reverse(Node head) {
        Node newHead = head;
        Node ith = head;

        while (ith != null) {
            Node prev = ith.prev;
            Node next = ith.next;

            ith.prev = next;
            ith.next = prev;

            newHead = ith;
            ith = next;
        }

        return newHead;
    }


    /*Create a new reversed list*/
    Node ReversedList(Node head) {
        Node reversed = null;

        while (head != null) {
            if (reversed != null) {
                Node newNode = new Node();
                newNode.data = head.data;
                newNode.next = reversed;
                reversed.prev = newNode;

                reversed = newNode;
            } else {//only for the 1st node
                reversed = new Node();
                reversed.data = head.data;
            }

            head = head.next;
        }

        return reversed;
    }

    /*Create a new reversed list*/
    Node ReversedListV2(Node head) {
        Node reversed = null;

        while (head != null) {
            Node newNode = new Node();
            newNode.data = head.data;
            if (reversed != null) {//but only update references if not in the first node of new list
                newNode.next = reversed;
                reversed.prev = newNode;
            }
            reversed = newNode;
            head = head.next;
        }

        return reversed;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
