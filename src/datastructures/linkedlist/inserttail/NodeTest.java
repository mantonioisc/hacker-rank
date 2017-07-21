package datastructures.linkedlist.inserttail;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class NodeTest {
    @Test
    public void insertNullHead() throws Exception {
        Node node = Node.insert(null, 100);

        assertThat(node.data, equalTo(100));
    }

    @Test
    public void insert() throws Exception {
        Node head = new Node();
        head.data = 1;

        Node node = Node.insert(head, 100);

        assertThat(node.next.data, equalTo(100));
    }

}