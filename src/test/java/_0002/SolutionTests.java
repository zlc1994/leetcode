package _0002;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTests {
    private final static Solution s = new Solution();

    private final static ListNode l1 = ListNode.newListNodeFromInteger(342);

    private final static ListNode l2 = ListNode.newListNodeFromInteger(465);

    @Test
    @DisplayName("342 + 465 = 807")
    void test() {
        assertEquals(s.addTwoNumbers(l1, l2), ListNode.newListNodeFromInteger(807));
    }
}
