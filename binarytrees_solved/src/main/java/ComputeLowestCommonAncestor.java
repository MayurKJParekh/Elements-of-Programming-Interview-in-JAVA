public class ComputeLowestCommonAncestor {

    /*
    10.3

    The algorithm isstructurally similar to a recursive postorder traversal, and the com¬
plexities are the same. Specifically, the time complexity and space complexity are
0(n) and 0(h), respectively, where h is the height of the tree.

    */

    private static class Status {
        public int numTargetNodes;
        public BinaryTreeNode<Integer> ancestor;

        public Status(int numTargetNodes, BinaryTreeNode<Integer> node) {
            this.numTargetNodes = numTargetNodes;
            this.ancestor = node;
        }
    }

    public static BinaryTreeNodednteger>

    LCA(BinaryTreeNode<Integer> tree,
        BinaryTreeNode<Integer> node0,
        BinaryTreeNode<Integer> node1) {
        return LCAHelper(tree, node0, node1).ancestor;
    }

    // Returns an object consisting of an int and a node. The int field is
// ®, 1, or 2 depending on how many of {node® , nodel} are present in
// the tree. If both are present in the tree, when ancestor is
// assigned to a non-null value, it is the LCA.
    private static Status LCAHelper(BinaryTreeNode<Integer> tree,
                                    BinaryTreeNode<Integer> node0,
                                    BinaryTreeNode<Integer> node1) {
        if (tree == null) {
            return new Status(0, null);
        }
        Status leftResult = LCAHelper(tree.left, node0, nodel);
        if (leftResult.numTargetNodes == 2) {
// Found both nodes in the left subtree.
            return leftResult;
        }
        Status rightResult = LCAHelper(tree.right, node0, nodel);
        if (rightResult.numTargetNodes == 2) {
// Found both nodes in the right subtree.
            return rightResult;
        }
        int numTargetNodes = leftResult.numTargetNodes + rightResult.numTargetNodes
                + (tree == node0 ? 1 : 0) + (tree == node1 ? 1 : 0);
        return new Status(numTargetNodes, numTargetNodes == 2 ? tree : null);
    }
}
