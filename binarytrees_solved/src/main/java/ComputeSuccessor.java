public class ComputeSuccessor {

    /*
    10.10

    Since the number of edges followed cannot be more than the tree height, the time
complexity is0(h),where h is the height of the tree.
    */

    public static BinaryTree<Integer> f

    indSuccessor(BinaryTree<Integer> node) {
        BinaryTree<Integer>iter = node;
        if (iter.right != null) {
// Find the leftmost element in node’s right subtree.
            iter = iter.right;
            while (iter.left != null) {
                iter = iter.left;
            }
            return iter;
        }
// Find the closest ancestor whose left subtree contains node.
        while (iter.parent != null && iter.parent.right == iter) {
            iter = iter.parent;
        }
// A return value of null means node does not have successor , i.e., it is
// the rightmost node in the tree.
        return iter.parent;
    }
}
