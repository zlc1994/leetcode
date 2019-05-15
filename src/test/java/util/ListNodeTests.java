package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ListNodeTests {
    private final static ListNode LIST_NODE  = ListNode.newListNodeFromInteger(123);

    @Test
    @DisplayName("LIST_NODE.size() = 3")
    void testListNodeSize() {
        assertEquals(3, LIST_NODE.size());
    }

    @Test
    void testListNodeEquals() {
        assertEquals(ListNode.newListNodeFromInteger(123), LIST_NODE);
        assertNotEquals(ListNode.newListNodeFromInteger(3), LIST_NODE);
    }

    @Test
    void testListNodeHashCode() {
        assertEquals(321, LIST_NODE.hashCode());
    }
}
