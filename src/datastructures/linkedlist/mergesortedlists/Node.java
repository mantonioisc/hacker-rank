package datastructures.linkedlist.mergesortedlists;

public class Node {
    int data;
    Node next;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
  Merge two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/

    Node mergeLists(Node headA, Node headB) {
        Node merged;
        if (headA == null) {
            merged = headB;
        } else if (headB == null) {
            merged = headA;
        } else {//both headA and headB are not null
            //determinate new head
            if (headA.data < headB.data) {
                merged = headA;
                headA = headA.next;
            } else {
                merged = headB;
                headB = headB.next;
            }

            Node ith = merged;//leave merged list head untouched, we need to advance further down the new list
            while (headA != null && headB != null) {
                if (headA.data < headB.data) {//^ we only advance listA or listB but not both
                    ith.next = headA;//*
                    headA = headA.next;//^
                } else {
                    ith.next = headB;//*
                    headB = headB.next;//^
                }
                ith = ith.next;//* I was missing this, advance merged list reference
            }

            //one list could have some elements left
            if (headA != null) {
                ith.next = headA;
            } else {//headB could be null, but we don't care
                ith.next = headB;
            }
        }

        return merged;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
