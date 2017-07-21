package datastructures.linkedlist.delete;

public class Node {
    int data;
    Node next;

    Node Delete(Node head, int position) {
        if (head != null) {
            if (position == 0) {
                Node newHead = head.next;
                head.next = null;//make Node instance available for gc
                return newHead;
            } else if (position == 1) {//Special case for the second on list, this is not needed when inserting!!!
                Node removed = head.next;
                head.next = removed.next;
                removed.next = null;//make Node instance available for gc
            } else if (head.next != null) {//For position >= 2. The null check is to protect against a bigger index passed in a list of one element
                int i = 1;//1 must be one or it will fail
                Node ith = head.next;//Since we have a special case for pos=1, we need to start a node after that compared to insertion algorithm

                while (i++ < position - 1 && ith.next != null) {//(pos - 1) since we are stopping 1 node before the one we want to remove
                    ith = ith.next;
                }

                if (ith.next != null) {//if position > size nothing will happen, this "if" is to guard against NPE
                    Node removed = ith.next;
                    ith.next = removed.next;
                    removed.next = null;//make Node instance available for gc
                }
            }
        }
        return head;
    }

    public static Node delete(Node head, int position) {
        return new Node().Delete(head, position);
    }
}
