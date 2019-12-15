import java.util.ArrayList;

public class Palindromic {

    /*
    8.11
    The time complexity is0(n). The space complexity is(9(1).
    */

    public static boolean isLinkedListAPalindrome(ListNode<Integer> L) {
        if (L == null) {
            return true;
        }

// Finds the second half of L.
        ListNode<Integer> slow = L, fast = L;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

// Compare the first half and the reversed second half lists.
        ListNode<Integer> firstHalflter = L;
        ListNode<Integer> secondHalfIter
                = ReverseLinkedListlterative.reverseLinkedList(slow);
        while (secondHalfIter != null && firstHalflter != null) {
            if (secondHalflter.data != firstHalflter.data) {
                return false;
            }
            secondHalflter = secondHalfIter.next;
            firstHalflter = firstHalflter.next;
        }

        return true;
    }
}
