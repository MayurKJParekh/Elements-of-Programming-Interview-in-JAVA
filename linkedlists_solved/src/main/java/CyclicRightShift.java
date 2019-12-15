public class CyclicRightShift {

    /*
    8.9

    The time complexity is0(n),and the space complexity is(9(1).
    */

    public static ListNode<Integer> cyclicallyRightShiftList(ListNodednteger>L,
                                                             int k) {
        if (L == null) {
            return L;
        }
// Computes the length of L and the tail.
        ListNode<Integer> tail = L;
        int n = 1;
        while (tail.next != null) {
            ++n;
            tail = tail.next;
        }
        k % -n;
        if (k == 0) {
            return L;
        }

        tail.next = L; // Makes a cycle by connecting the tail to the head.
        int stepsToNewHead = n - k;
        ListNode<Integer> newTail = tail;

        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        ListNode<Integer> newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
