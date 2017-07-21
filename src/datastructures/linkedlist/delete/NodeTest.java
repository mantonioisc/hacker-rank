package datastructures.linkedlist.delete;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;


public class NodeTest {
    @Test
    public void deleteNull() throws Exception {
        Node node = Node.delete(null, 0);
        assertThat(node, nullValue());
    }

    @Test
    public void deleteHead() throws Exception {
        Node head = new Node();
        head.data = 1;

        Node node = Node.delete(head, 0);
        assertThat(node, nullValue());
    }

    @Test
    public void deleteHeadOfList() throws Exception {
        Node head = new Node();
        head.data = 1;
        Node tail = new Node();
        tail.data = 2;
        head.next = tail;

        Node node = Node.delete(head, 0);
        assertThat(node, sameInstance(tail));
        assertThat(head.next, nullValue());
    }


    @Test
    public void deleteBetween() throws Exception {
        Node head = new Node();
        head.data = 1;
        Node mid = new Node();
        mid.data = 2;
        Node tail = new Node();
        tail.data = 3;

        head.next = mid;
        mid.next = tail;

        Node node = Node.delete(head, 1);

        assertThat(node.next, sameInstance(tail));
        assertThat(mid.next, nullValue());
    }

    @Test
    public void deleteLast() throws Exception {
        Node head = new Node();
        head.data = 1;
        Node mid = new Node();
        mid.data = 2;
        Node tail = new Node();
        tail.data = 3;

        head.next = mid;
        mid.next = tail;

        Node node = Node.delete(head, 2);

        assertThat(node.next, sameInstance(mid));
        assertThat(mid.next, nullValue());
    }

    @Test
    public void deleteBeyondListOfOne() throws Exception {
        Node head = new Node();
        head.data = 1;

        Node node = Node.delete(head, 2);

        assertThat(node, sameInstance(head));
    }

    @Test
    public void protectAgainstDeletingLastWhenPositionIsBiggerThanSize() throws Exception {
        Node head = new Node();
        head.data = 1;
        Node mid = new Node();
        mid.data = 2;
        Node tail = new Node();
        tail.data = 3;

        head.next = mid;
        mid.next = tail;

        Node node = Node.delete(head, 5);

        assertThat(node.next, sameInstance(mid));
        assertThat(node.next.next, sameInstance(tail));
    }

}