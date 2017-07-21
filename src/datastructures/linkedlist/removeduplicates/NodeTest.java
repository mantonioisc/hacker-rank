package datastructures.linkedlist.removeduplicates;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class NodeTest {
    @Test
    public void removeDuplicates() throws Exception {
        assertThat(Node.removeDuplicates(null), nullValue());

        Node head = new Node();
        head.data = 1;

        assertThat(Node.removeDuplicates(head), sameInstance(head));


        head.next = new Node();
        head.next.data = 1;
        head.next.next = new Node();
        head.next.next.data = 1;
        head.next.next.next = new Node();
        head.next.next.next.data = 2;

        Node node = Node.removeDuplicates(head);

        assertThat(node.data, is(equalTo(1)));
        assertThat(node.next.data, equalTo(2));
        assertThat(node.next.next, is(nullValue()));
    }

}