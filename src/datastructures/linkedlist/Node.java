package datastructures.linkedlist;

public class Node {
    int data;
    Node next;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    boolean hasCycle(Node head) {
        boolean cycle = false;

        if (head != null) {
            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    cycle = true;
                    break;
                }
            }
        }

        return cycle;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
