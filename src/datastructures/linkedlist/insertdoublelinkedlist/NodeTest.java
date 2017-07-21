package datastructures.linkedlist.insertdoublelinkedlist;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class NodeTest {
    @Test
    public void sortedInsertedInEmptyList() throws Exception {
        Node node = Node.sortedInserted(null, 1);

        assertThat(node.data, equalTo(1));
    }

    @Test
    public void sortedInsertedBeforeSingleElement() throws Exception {
        Node single = new Node();
        single.data = 2;

        Node node = Node.sortedInserted(single, 1);

        assertThat(node.data, equalTo(1));
        assertThat(node.next.data, equalTo(2));

        assertThat(node.prev, nullValue());
        assertThat(node.next, sameInstance(single));
        assertThat(node, sameInstance(single.prev));
        assertThat(node, sameInstance(node.next.prev));
        assertThat(node.next.next, nullValue());
    }

    @Test
    public void sortedInsertedAfterSingleElement() throws Exception {
        Node single = new Node();
        single.data = 2;

        Node node = Node.sortedInserted(single, 3);

        assertThat(node.data, equalTo(2));
        assertThat(node.next.data, equalTo(3));

        assertThat(node.prev, nullValue());
        assertThat(node, sameInstance(single));
        assertThat(node, sameInstance(node.next.prev));
        assertThat(node.next.next, nullValue());
    }

    @Test
    public void sortedInsertedBetweenElements() throws Exception {
        Node fst = new Node();
        fst.data = 1;

        Node trd = new Node();
        trd.data = 3;

        fst.next = trd;
        trd.prev = fst;

        Node node = Node.sortedInserted(fst, 2);

        assertThat(node.data, equalTo(1));
        assertThat(node.next.data, equalTo(2));
        assertThat(node.next.next.data, equalTo(3));

        assertThat(node, sameInstance(fst));
        assertThat(fst.prev, nullValue());
        assertThat(fst.next, sameInstance(trd.prev));
        assertThat(trd.next, nullValue());
    }

    @Test
    public void sortedInsertedAfterElements() throws Exception {
        Node fst = new Node();
        fst.data = 1;

        Node snd = new Node();
        snd.data = 2;

        fst.next = snd;
        snd.prev = fst;

        Node node = Node.sortedInserted(fst, 3);

        assertThat(node.data, equalTo(1));
        assertThat(node.next.data, equalTo(2));
        assertThat(node.next.next.data, equalTo(3));

        assertThat(node, sameInstance(fst));
        assertThat(fst.prev, nullValue());
        assertThat(snd, sameInstance(fst.next));
        assertThat(fst, sameInstance(snd.prev));
        assertThat(snd.next, not(nullValue()));
        assertThat(snd, sameInstance(snd.next.prev));
        assertThat(snd.next.next, nullValue());
    }
}