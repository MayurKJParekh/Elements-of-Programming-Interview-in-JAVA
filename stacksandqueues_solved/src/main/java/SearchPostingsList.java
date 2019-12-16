public class SearchPostingsList {

    /*
    9.5
    The iterative solution uses a stack to simulate the recursive algorithm. The keyinsight is that for every node, we want to visit its next node after visiting its jump
node. A stack works well because of itslast-in, first-outsemantics. Specifically, when
processing a node, we push its next node on to the stack and then we push its jump
node on to the stack. This way we process the jump node before the next node.

Let n denote the number of tree nodes. For both algorithms, the time complexity
is 0(n),since the total time spent on each node is (9(1), and the space complexity is
0(n). The recursive implementation has a maximum function call stack depth of n;
the iterative implementation has a maximum stack size of n. A worst-case input is
one where every node's jump node and next node are equal.
    */

    public static void setJumpOrder(PostingListNode L) {
        setJumpOrderHelper(L, 0);
    }
    private static int setJumpOrderHelper(PostingListNode L, int order) {
        if (L != null && L.order == -1) {
            L.order = order++;
            order = setJumpOrderHelper(L.jump , order);
            order = setJumpOrderHelper(L.next , order);
        }
        return order;

    }

    public static void setJumpOrder(PostingListNode L) {
        Deque<PostingListNode> s = new LinkedList<>();
        int order =0;
        s.addFirst(L);
        while (!s.isEmpty()) {
            PostingListNode curr = s.removeFirst();
            if (curr != null && curr.order == -1) {
                curr.order = order++;
// Stack is last-in, first -out, and we want to process
// the jump node first, so push next, then push jump.
                s.addFirst(curr.next);
                s.addFirst(curr.jump);
            }
        }
    }
}
