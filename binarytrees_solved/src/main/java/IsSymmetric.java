public class IsSymmetric {

    /*
    10.2
    A binary tree issymmetric if you can draw a vertical line through the root and then
the left subtree is the mirror image of the right subtree.

    */

    public static boolean isSymmetric (BinaryTreeNode <Integer> tree) {
        return tree == null || checkSymmetric (tree . left , tree.right);
    }
    private static boolean checkSymmetric (BinaryTreeNode <Integer> subtreeR,
                                           BinaryTreeNode <Integer> subtreel) {
        if (subtreeR == null && subtreel == null) {
            return true ;
        } else if (subtreeR != null && subtreel != null) {
            return subtreeR . data == subtreel . data
                    && checkSymmetric (subtreeR.left ,subtreel.right)
                    && checkSymmetric (subtreeR.right, subtreel.left) ;
        }
// One subtree is empty, and the other is not.
        return false;
    }

}
