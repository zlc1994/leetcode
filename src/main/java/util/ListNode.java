package util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode newListNodeFromInteger(int x) {
        ListNode head = new ListNode(0);
        ListNode p = head;

        while (x != 0) {
            p.next = new ListNode(x % 10);
            x = x / 10;
            p = p.next;
        }

        return head.next;
    }

    public int size() {
        int result = 0;
        ListNode p = this;
        while (p != null) {
            result++;
            p = p.next;
        }
        return result;
    }

    public void add(ListNode l) {
        ListNode p = this;

        while (p.next != null) {
            p = p.next;
        }

        p.next = l;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ListNode)) {
            return false;
        }

        ListNode p = this;
        ListNode l = (ListNode) o;

        while (p != null && l != null) {
            if (p.val != l.val) {
                return false;
            }
            p = p.next;
            l = l.next;
        }

        return p == null && l == null;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        ListNode p = this;

        while (p != null) {
            hashCode = hashCode * 10 + p.val;
            p = p.next;
        }

        return hashCode;
    }

    public void show() {
        ListNode p = this;

        while (p != null) {
            System.out.printf("%d -> ", p.val);
            p = p.next;
        }

        System.out.println("null");
    }
}
