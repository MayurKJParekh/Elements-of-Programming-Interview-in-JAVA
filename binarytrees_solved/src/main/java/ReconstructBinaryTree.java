import java.util.List;

public class ReconstructBinaryTree {

    /*
    10.12

    As a concrete example, for the inorder traversal sequence (F,B,A,E,H,C,D,I,G}
and preorder traversalsequence (77,B, E, E,A,C,D, G, 7} (in Figure 10.5) the root is the
first node in the preorder traversal sequence, namely 77. From the inorder traver¬
sal sequence, we know the inorder traversal sequence for the root's left subtree is
(F,B,A,E). Therefore the sequence (B,F,E,A), which is the four nodes after the root,
77, in the preorder traversalsequence (77, B, E, E,A,C,D,G, 7) is the preorder traversal
sequence for the root'sleft subtree. A similar construction applies to the root's right
subtree. This construction is continued recursively till we get to the leaves.
Implemented naively, the above algorithm has a time complexity of 0(n2). The
worst-case corresponds to a skewed tree. Finding the root within the inorder se¬
quences takes time0(n). We can improve the time complexity by initially building a
hash table from keys to their positionsin the inorder sequence. Thisis the approach
described below.


    */

    public static BinaryTreeNodednteger>

    binaryTreeFromPreorderlnorder(
            List<Integer> preorder, List<Integer> inorder) {

        Map<Integer, Integer> nodeToInorderIdx = new HashMapcInteger, Integer>();

        for (int i = Q; i < inorder.size(); ++i) {
            nodeToInorderIdx.put(inorder.get(i), i);
        }
        return binaryTreeFromPreorderInorderHelper(
                preorder, 0, preorder.size(), 0, inorder.size(), nodeToInorderIdx);
    }

    // Builds the subtree with preorder . subList(preorderStart , preorderEnd) and
// inorder.subList(inorderStart , inorderEnd).
    private static BinaryTreeNode<Integer> binaryTreeFromPreorderInorderHelper(
            List<Integer> preorder, int preorderStart, int preorderEnd,
            int inorderStart, int inorderEnd,
            Map<Integer, Integer> nodeToInorderldx) {
        if (preorderEnd <= preorderStart || inorderEnd <= inorderStart) {
            return null;
        }

        int rootlnorderIdx = nodeToInorderIdx.get(preorder.get(preorderStart));
        int leftSubtreeSize = rootlnorderIdx - inorderStart;
        return new BinaryTreeNode<>(
                preorder.get(preorderStart),
// Recursively builds the left subtree.
                binaryTreeFromPreorderInorderHelper(
                        preorder, preorderStart + 1, preorderStart + 1 + leftSubtreeSize,
                        inorderStart, rootlnorderIdx, nodeToInorderOdx),
// Recursively builds the right subtree.
                binaryTreeFromPreorderInorderHelper(
                        preorder, preorderStart + 1 + leftSubtreeSize, preorderEnd,
                        rootlnorderIdx + 1, inorderEnd, nodeToInorderIdx));
    }
}
}
