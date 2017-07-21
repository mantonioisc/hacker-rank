package datastructures.linkedlist.getnodevalue;

public class Node {
    int data;
    Node next;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
  Get Nth element from the end in a linked list of integers
  Number of elements in the list will always be greater than N.
  Node is defined as
  class Node {
     int data;
     Node next;
  }
*/

    int GetNode(Node head, int n) {
        Node ith = head != null ? head : new Node();//to return 0 if head == null
        int i = 0;//"n" is 0 based "i" should be too

        while (head != null) {
            if (i > n) {//drag ith a bit, only start incrementing it after we have advanced "n" nodes
                ith = ith.next;
            }
            i++;
            head = head.next;
        }

        return ith.data;
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
