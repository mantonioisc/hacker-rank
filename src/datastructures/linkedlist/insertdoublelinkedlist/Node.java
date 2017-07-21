package datastructures.linkedlist.insertdoublelinkedlist;

public class Node {
    int data;
    Node next;
    Node prev;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    Node SortedInsert(Node head, int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (head == null) {//no nodes
            head = newNode;
        } else if (data < head.data) {//before the beginning of list
                newNode.next = head;
                head.prev = newNode;

                head = newNode;
        } else {//between nodes or after
            Node ith = head;

            /*
            While not at the last element AND while ith not in range a <= x <= b, keep incrementing ith until in range
            or the last element (to insert new at last).

            This will position the ith cursor before insertion point of before the end of list, in contrast with
            editorial solution that sets cursor after insertion point or at the end (not symmetrical for me).
            The key is the condition that stops before insertion point whenever there are more elements at the end or not
            (this is symmetrical behavior of ith cursor at the cost of bit more complex iteration condition)
             */
            while (ith.next != null && !(ith.data <= data && data <= ith.next.data)) {//check this condition carefully is the key for this
                ith = ith.next;
            }

            Node tail = ith.next;

            ith.next = newNode;
            newNode.prev = ith;

            if (tail != null) {
                newNode.next = tail;
                tail.prev = newNode;
            }
        }

        return head;
    }

    Node SortedInsertV1(Node head, int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (head == null) {//no nodes
            head = newNode;
        } else if (head.next == null) {//before or after one
            if (data >= head.data) {
                head.next = newNode;
                newNode.prev = head;
            } else {
                newNode.next = head;
                head.prev = newNode;

                head = newNode;
            }
        } else {//between nodes
            Node ith = head;

            //while not at the last element AND while ith not in range a < x < b, keep incrementing ith until in range or the last element (to insert new at last)
            while (ith.next != null && !(ith.data <= data && data <= ith.next.data)) {//check this condition carefully is the key for this
                ith = ith.next;
            }

            Node tail = ith.next;

            ith.next = newNode;
            newNode.prev = ith;

            if (tail != null) {
                newNode.next = tail;
                tail.prev = newNode;
            }
        }

        return head;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    static Node sortedInserted(Node node, int data) {
        return new Node().SortedInsert(node, data);
    }
}
