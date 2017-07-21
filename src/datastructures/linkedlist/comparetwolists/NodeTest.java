package datastructures.linkedlist.comparetwolists;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;


public class NodeTest {
    @Test
    public void compareListsV1() throws Exception {
        assertThat(Node.CompareListsV1(createList(), createList()), equalTo(1));
        assertThat(Node.CompareListsV1(createList(), new Node()), equalTo(0));
    }

    @Test
    public void compareListsV2() throws Exception {
        assertThat(Node.CompareListsV2(createList(), createList()), equalTo(1));
        assertThat(Node.CompareListsV2(createList(), new Node()), equalTo(0));

    }

    @Test
    public void compareLists() throws Exception {
        assertThat(Node.CompareLists(createList(), createList()), equalTo(1));
        assertThat(Node.CompareLists(createList(), new Node()), equalTo(0));

    }

    private Node createList() {
        Node head = new Node();
        head.data = 1;
        head.next = new Node();
        head.next.data = 2;
        head.next.next = new Node();
        head.next.next.data = 3;
        return head;
    }
}