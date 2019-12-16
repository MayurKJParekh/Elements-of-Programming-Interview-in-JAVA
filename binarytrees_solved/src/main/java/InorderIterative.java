import java.util.Collections;
import java.util.List;

public class InorderIterative {

    /*
    10.7

    The time complexity is 0(n),since the total time spent on each node is(9(1). The
space complexity is 0(h), where h is the height of the tree. This space is allocated
dynamically, specifically it is the maximum depth of the function call stack for the
recursive implementation.
    */

    public static List<Integer> BSTInSortedOrder(BSTNode<Integer> tree) {
        Deque<BSTNode<Integer>> s = new LinkedList<>();
        BSTNode<Integer> curr = tree;
        List<Integer> result = new ArrayList<>();
        while (!s.isEmpty() || curr != null) {
            if (curr != null) {
                s.addFirst(curr);
                // Going left.
                curr = curr.lef t;
            } else {
                // Going up .
                curr = s.removeFirst();
                result.add(curr.data);
                // Going right.
                curr = curr.right;
            }
        }
        return result;
    }
}
