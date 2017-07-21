package datastructures.linkedlist.reverse;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class NodeTest {
    @Test
    public void reverse() throws Exception {
        Node head = new Node();
        head.data = 1;

        Node node = Node.reverse(head);
        assertThat(node, not(sameInstance(head)));
        assertThat(node.data, equalTo(head.data));

        Node mid = new Node();
        mid.data = 2;

        Node tail = new Node();
        tail.data = 3;

        mid.next = tail;
        head.next = mid;

        Node reversed = Node.reverse(head);

        assertThat(reversed, not(sameInstance(tail)));
        assertThat(reversed.data, equalTo(3));
        assertThat(reversed.next.data, equalTo(2));
        assertThat(reversed.next.next.data, equalTo(1));
    }

    @Test
    public void reverseInPlace() throws Exception {
        Node head = new Node();

        Node node = Node.reverseInPlace(head);
        assertThat(node, sameInstance(head));

        Node mid = new Node();
        Node tail = new Node();

        mid.next = tail;
        head.next = mid;

        Node reversed = Node.reverseInPlace(head);
        assertThat(reversed, sameInstance(tail));
        assertThat(reversed.next, sameInstance(mid));
        assertThat(reversed.next.next, sameInstance(head));
    }

}