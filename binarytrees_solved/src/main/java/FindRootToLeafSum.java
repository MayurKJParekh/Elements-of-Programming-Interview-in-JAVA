public class FindRootToLeafSum {

    /*
    10.6

    Design an algorithm to compute the sum of the binary numbers represented by the
root-to-leaf paths.

    The time complexity and space complexity are0(n) and 0(h),respectively.
    */

    public static int sumRootToLeaf(BinaryTreeNode<Integer> tree) {
        return sumRootToLeafHelper(tree, 0);
    }

    private static int sumRootToLeafHelper(BinaryTreeNode<Integer> tree,
                                           int partialPathSum) {
        if (tree == null) {
            return 0;
        }
        partialPathSum = partialPathSum * 2 + tree.data;
        if (tree.left == null && tree.right == null) { // Leaf.
            return partialPathSum;
        }
// Son-leaf .
        return sumRootToLeafHelper(tree.left, partialPathSum)
                + sumRootToLeafHelper(tree.right, partialPathSum);
    }

}
