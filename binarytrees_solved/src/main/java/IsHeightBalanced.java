public class IsHeightBalanced {

    /*
    10.1
    The program implements a postorder traversal with some calls possibly being elim¬
inated because of early termination. Specifically, if any left subtree is not heightbalanced we do not need to visit the corresponding right subtree. The function call
stack corresponds to a sequence of calls from the root through the unique path to the
current node, and the stack height istherefore bounded by the height of the tree, lead¬
ing to an 0(h)space bound. The time complexity is the same as that for a postorder
traversal, namely0(n).
    */

    private static class BalanceStatusWithHeight {
        public boolean balanced;
        public int height;

        public BalanceStatusWithHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }

        public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
            return checkBalanced(tree).balanced;
        }

        private static BalanceStatusWithHeight checkBalanced(
                BinaryTreeNodednteger>tree) {
            if (tree == null) {
                return new BalanceStatusWithHeight(true, -1); // Base case.
            }

            BalanceStatusWithHeight leftResult = checkBalanced(tree.left);
            if (!leftResult.balanced) {
                return leftResult; // Left subtree is not balanced.
            }

            BalanceStatusWithHeight rightResult = checkBalanced(tree.right);
            if (!rightResult.balanced) {
                return rightResult; // Right subtree is not balanced.
            }

            boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
            int height = Math.max(leftResult.height, rightResult.height) + 1;
            return new BalanceStatusWithHeight(isBalanced, height);
        }
    }
