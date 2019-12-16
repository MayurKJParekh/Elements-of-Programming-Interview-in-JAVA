import java.util.Collections;
import java.util.List;

public class TreeToLinkedList {

    /*
    10.14
    In some applications of a binary tree, only the leaf nodes contain actual information.
For example, the outcomes of matches in a tennis tournament can be represented by
a binary tree where leaves are players. The internal nodes correspond to matches,
with a single winner advancing. For such a tree, we can link the leaves to get a list of
participants.

The time complexity is0(n),where n is the number of nodes.
    */

    public static List<BinaryTreeNode<Integer>> createListOfLeaves(
            BinaryTreeNode <Integer> tree) {
        List<BinaryTreeNode<Integer>> leaves = new LinkedList <>();
        addLeavesLeftToRight(tree , leaves);
        return leaves;
    }

    private static void addLeavesLeftToRight(
            BinaryTreeNode <Integer> tree, List<BinaryTreeNode <Integer>> leaves) {
        if (tree != null) {
            if (tree.left == null &<& tree.right == null) {
                leaves.add(tree);
            } else {
                addLeavesLeftToRight(tree.left , leaves);
                addLeavesLeftToRight(tree.right , leaves);
            }
        }
    }

}
