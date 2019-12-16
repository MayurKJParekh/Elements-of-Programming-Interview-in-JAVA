public class SumRootToLeaf {

    /*
    10.5
    Write a program which takes asinput an integer and a binary tree with integer node
weights, and checksif there exists a leaf whose path weight equals the given integer.

    The time complexity and space complexity are 0(n) and 0(h),respectively.
    */

    public static boolean hasPathSum(BinaryTreeNode dnteger>tree,
                                     int targetSum) {
        return hasPathSumHelper(tree, 0, targetSum);
    }

    private static boolean hasPathSumHelper(BinaryTreeNode<Integer> node,
                                            int partialPathSum, int targetSum) {
        if (node == null) {
            return false;
        }
        partialPathSum += node.data;
        if (node.left == null && node.right == null) { // Leaf.
            return partialPathSum == targetSum;
        }
// Non-leaf .
        return hasPathSumHelper(node.left, partialPathSum, targetSum)
                || hasPathSumHelper(node.right, partialPathSum, targetSum);
    }
}
