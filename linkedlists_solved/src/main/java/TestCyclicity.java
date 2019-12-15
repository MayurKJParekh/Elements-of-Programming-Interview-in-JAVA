import java.util.HashMap;
import java.util.Map;

public class TestCyclicity {

    /*
    8.3

    This problem has several solutions. If space is not an issue, the simplest
approach is to explore nodes via the next field starting from the head and storing
117
visited nodes in a hash table—a cycle exists if and only if we visit a node already
in the hash table. If no cycle exists, the search ends at the tail (often represented by
having the next field set to null). This solution requires 0(n) space, where n is the
number of nodesin the list.

Thisidea can be made to work in linear time—use a slow iterator and a fast iterator
to traverse the list. In each iteration, advance the slow iterator by one and the fast
iterator by two. The list has a cycle if and only if the two iterators meet. The reasoning
is as follows: if the fast iterator jumps over the slow iterator, the slow iterator will
equal the fast iterator in the nextstep.

Let F be the number of nodes to the start of the cycle, C the number of nodes on the
cycle, and n the total number of nodes. Then the time complexity is 0(F) + 0(C) =
0(n)—0(F)for both pointersto reach the cycle, and 0(C) for them to overlap once the
slower one enters the cycle.
    */

    public static ListNode<Integer> hasCycle(ListNode<Integer> head) {
        ListNode<Integer> fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
// There is a cycle, so now let’s calculate the cycle length.
                int cycleLen = 0;
                do {
                    ++cycleLen;
                    fast = fast.next;
                } while (slow != fast);


// Finds the start of the cycle.
                ListNode<Integer> cycleLenAdvancedlter = head;
// cycleLenAdvancedlter pointer advances cycleLen first.
                while (cycleLen-- > 0) {
                    cycleLenAdvancedlter = cycleLenAdvancedlter.next;
                }


                ListNode<Integer> iter = head;
// Both iterators advance in tandem.
                while (iter != cycleLenAdvancedlter) {
                    iter = iter.next;
                    cycleLenAdvancedlter = cycleLenAdvancedlter.next;
                }
                return iter; // iter is the start of cycle.
            }
            return null; // no cycle.
        }

    }
