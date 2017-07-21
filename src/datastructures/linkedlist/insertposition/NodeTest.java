package datastructures.linkedlist.insertposition;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class NodeTest {
    @Test
    public void insertAtNullHead() throws Exception {
        Node node = Node.insertNth(null, 100, 0);

        assertThat(node.data, equalTo(100));
    }

    @Test
    public void insertAtHead() throws Exception {
        Node tail = new Node();
        tail.data = 1;

        Node head = Node.insertNth(tail, 100, 0);

        assertThat(head, not(sameInstance(tail)));
        assertThat(head.next, sameInstance(tail));
        assertThat(head.data, equalTo(100));
    }

    @Test
    public void insertAtTail() throws Exception {
        Node head = new Node();
        head.data = 1;

        Node node = Node.insertNth(head, 100, 1);

        assertThat(node, sameInstance(head));
        assertThat(node.next, not(sameInstance(head)));

        assertThat(node.data, equalTo(1));
        assertThat(node.next.data, equalTo(100));
    }

    @Test
    public void insertAfterHead() throws Exception {
        Node head = new Node();
        head.data = 1;

        Node node = Node.insertNth(head, 100, 2);

        assertThat(node, sameInstance(head));
        assertThat(node.next, not(head));

        assertThat(node.data, equalTo(1));
        assertThat(node.next.data, equalTo(100));
    }

    @Test
    public void insertBetween() throws Exception {
        Node head = new Node();
        head.data = 1;
        head.next = new Node();
        head.next.data = 2;

        Node node = Node.insertNth(head, 100, 1);

        assertThat(node, sameInstance(head));
        assertThat(node.next, not(sameInstance(head)));

        assertThat(node.data, equalTo(1));
        assertThat(node.next.data, equalTo(100));
        assertThat(node.next.next.data, equalTo(2));
    }
}