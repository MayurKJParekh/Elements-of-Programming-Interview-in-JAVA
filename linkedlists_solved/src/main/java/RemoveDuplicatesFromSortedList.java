public class RemoveDuplicatesFromSortedList {

    /*
    8.8
    Determining the time complexity requires a little amortized analysis. A single node
may take more than 0(1) time to process if there are many successive nodes with
the same value. A clearer justification for the time complexity is that each link is
traversed once,so the time complexity is0(n). The space complexity is0(1).
    */

    public static ListNode<Integer> removeDuplicates(ListNode<Integer> L) {
        ListNode<Integer> iter = L;
        while (iter != null) {
// Uses nextDistinct to find the next distinct value.
            ListNode<Integer> nextDistinct = iter.next;
            while (nextDistinct != null && nextDistinct.data == iter.data) {
                nextDistinct = nextDistinct.next;
            }
            iter.next = nextDistinct;
            iter = nextDistinct;
        }
        return L;
    }

}
