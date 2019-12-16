import java.util.Collections;
import java.util.List;

public class PreorderIterative {

    /*
    10.8

    Since we push and pop each node exactly once, the time complexity is 0(n), where
n is the number of nodes. The space complexity is0(h), where h is the height of the
tree, since, with the possible exception of the top of the stack, the nodes in the stack
correspond to the right children of the nodes on a path beginning at the root.
    */

    public static List<Integer> preorderTraversal(BinaryTreeNode<Integer> tree) {
        Deque<BinaryTreeNode<Integer>> path = new LinkedList<>();
        path.addFirst(tree);
        List<Integer> result = new ArrayList<>();
        while (!path.isEmpty()) {
            BinaryTreeNode<Integer> curr = path.removeFirst();
            if (curr != null) {
                result.add(curr.data);
                path.addFirst(curr.right);
                path.addFirst(curr.left);
            }
        }
        return result
    }
}
