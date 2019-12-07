public class ImplementFastSorting {

    /*
    14.9

    The time complexity is the same as that of mergesort, i.e., 0(n log n). Though no
memory is explicitly allocated, the space complexity is(9(log n). Thisis the maximum
function call stack depth,since each recursive call is with an argument that is half as
long.
    */

    public static ListNode<Integer> stableSortList(ListNode<Integer> L) {
// Base cases: L is empty or a single node , nothing to do.
        if (L == null || L.next == null) {
            return L;
        }
// Find the midpoint of L using a slow and a fast pointer.
        ListNode<Integer> preSlow = null, slow = L, fast = L;
        while (fast != null && fast.next != null) {
            preSlow = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        preSlow.next = null; // Splits the list into two equal-sized lists.
        return MergeSortedLists.mergeTwoSortedLists(stableSortList(L),
                stableSortList(slow));
    }
}
