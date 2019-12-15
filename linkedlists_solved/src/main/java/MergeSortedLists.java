public class MergeSortedLists {

    /*
    8.1

    The worst-case, from a runtime perspective, corresponds to the case when the lists
are of comparable length, so the time complexity is 0(n + m). (In the best-case, one
list is much shorter than the other and all its entries appear at the beginning of the
merged list.) Since we reuse the existing nodes, the space complexity is0(1).
    */

    public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
                                                        ListNode<Integer> L2) {
// Creates a placeholder for the result.
        ListNode<Integer> dummyHead = new ListNode<>(0, null);
        ListNode<Integer> current = dummyHead;
        ListNode<Integer> pi = L1, p2 = L2;
        while (pi != null && p2 != null) {
            if (pi.data <= p2.data) {
                current.next = pi;
                pi = pi.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;
        }
// Appends the remaining nodes of pi or p2.
        current.next = pi != null ? pi : p2;
        return dummyHead.next;
    }
}
