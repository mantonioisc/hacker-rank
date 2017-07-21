package datastructures.linkedlist.comparetwolists;


public class Node {
    int data;
    Node next;

    /*
  Compare two linked lists A and B
  Return 1 if they are identical and 0 if they are not.
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/
    static int CompareListsV1(Node headA, Node headB) {
        if (headA != null && headB != null) {
            do {
                if (headA.data != headB.data) {
                    return 0;
                }
                headA = headA.next;
                headB = headB.next;
            } while (headA != null && headB != null);

            return headA == null && headB == null ? 1 : 0;
        } else {
            return 0;
        }
    }

    static int CompareListsV2(Node headA, Node headB) {
        while (headA != null && headB != null) {
            if (headA.data != headB.data) {
                return 0;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA == null && headB == null ? 1 : 0;
    }

    static int CompareLists(Node headA, Node headB) {
        //Making use of short circuit evaluation
    while (headA != null && headB != null && headA.data == headB.data) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA == null && headB == null ? 1 : 0;
    }
}
