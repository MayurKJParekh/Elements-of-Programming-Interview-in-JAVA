import java.util.List;

public class ReconstructBinaryTreeWithMarkers {

    /*
    10.13
    Many different binary trees have the same preorder traversalsequence.
In this problem, the preorder traversal computation is modified to mark where a
left or right child is empty. For example, the binary tree in Figure 10.5 on the facing
page yields the following preorder traversal sequence:
(H,B,F, null,null, E,A,null,null,null,C, null,D, null,G,I,null,null,null)


The time complexity is0(n), where n is the number of nodes in the tree.
    */

    // Global variable , tracks current subtree.
    private static Integer subtreeldx;
    public static BinaryTreeNoded<Integer> reconstructPreorder (
            Listdnteger > preorder) {
        subtreeldx = 0;
        return reconstructPreorderSubtree(preorder) ;
    }

    // Reconstructs the subtree that is rooted at subtreeldx .
    private static BinaryTreeNod <Integer> reconstructPreorderSubtree (
            List<Integer> preorder) {
        Integer subtreeKey = preorder.get(subtreeldx) ;
        ++subtreeldx ;
        if (subtreeKey == null) {
            return null ;
        }
// Note that reconstructPreorderSubtree updates subtreeldx. So the order of
// following two calls are critical.
        BinaryTreeNode <Integer> leftSubtree = reconstructPreorderSubtree(preorder) ;
        BinaryTreeNode <Integer> rightSubtree = reconstructPreorderSubtree(preorder) ;
        return new BinaryTreeNode<>(subtreeKey , leftSubtree, rightSubtree);
}
