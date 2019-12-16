public class ComputeRightSiblingTree {

    /*
    10.16
    Since we perform (9(1) computation per node, the time complexity is0(n). The space
complexity is(9(1).
    */

    public static void constructRightSibling(BinaryTreeNode <Integer> tree) {
        BinaryTreeNode<Integer> leftStart = tree;
        while (leftStart != null && leftStart.left != null) {
            populateLowerLevelNextField(leftStart);
            leftStart = leftStart.left;
        }
    }

    private static void populateLowerLevelNextField(
            BinaryTreeNode <Integer> startNode) {
        BinaryTreeNode <Integer> iter = startNode;
        while (iter != null) {
// Populate left child’s next field.
            iter.left.next = iter.right;
// Populate right child’s next field if iter is not the last node of this
// level .
            if (iter.next != null) {
                iter.right.next = iter.next.left ;
            }
            iter = iter.next ;
        }

    }
}
