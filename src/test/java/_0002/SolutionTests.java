package _0002;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTests {
    private static final Solution s = new Solution();

    private static final ListNode l1 = ListNode.newListNodeFromInteger(342);

    private static final ListNode l2 = ListNode.newListNodeFromInteger(465);

    @Test
    @DisplayName("342 + 465 = 807")
    void test() {
        assertEquals(s.addTwoNumbers(l1, l2), ListNode.newListNodeFromInteger(807));
    }
}
