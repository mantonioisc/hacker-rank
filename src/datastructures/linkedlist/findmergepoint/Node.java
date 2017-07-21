package datastructures.linkedlist.findmergepoint;

public class Node {
    int data;
    Node next;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * A while is used because is guaranteed that both lists will merge, otherwise it will cycle forever
     * The way this works is as follows. If both list merge at the same index while condition will detect it, just by
     * advancing the two lists at the same time with currentX = currentX.next
     * If the list don't have the same number of nodes before the merging point, the pointer for each list at the end switch
     * to the other list, every time that happens the lists will level by 1 for the number of elements necessary to arrive
     * at the merge point.
     * @param headA
     * @param headB
     * @return
     */
    int FindMergeNode(Node headA, Node headB) {
        Node currentA = headA;
        Node currentB = headB;

        while (currentA != currentB) {
            if (currentA.next != null) {//if not at the end advance
                currentA = currentA.next;
            } else { //* if at the end start at the other list, it must do the same at the other list
                currentA = headB;
            }

            if (currentB.next != null) {
                currentB = currentB.next;
            } else {
                currentB = headA;//*
            }
        }
        return currentB.data;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
