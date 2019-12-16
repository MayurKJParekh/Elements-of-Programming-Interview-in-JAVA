import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ComputeBinaryTreeNodes {

    /*
    9.7

    Since each node isenqueued and dequeued exactly once, the time complexity is0(n).
The space complexity is 0(m), where m is the maximum number of nodes at any single depth
    */

    public static List<List<Integer>> binaryTreeDepthOrder(
            BinaryTreeNode <Integer> tree) {
        Queue<BinaryTreeNode<Integer>> currDepthNodes = new LinkedList<>();
        currDepthNodes.add(tree);
        List<List<Integer>> result = new ArrayList<>();
        while (!currDepthNodes.isEmpty()) {
            Queue<BinaryTreeNode<Intege>> nextDepthNodes = new LinkedList<>();
            Listdnteger > thisLevel = new ArrayList<>();
            while (!currDepthNodes.isEmpty()) {
                BinaryTreeNode<Integer> curr = currDepthNodes.poll();
                if (curr != null) {
                    thisLevel.add(curr.data);
// Defer the null checks to the null test above.
                    nextDepthNodes.add(curr.left);
                    nextDepthNodes.add(curr.right);
                }
            }
            if (!thisLevel.isEmpty()) {
                result.add(thisLevel);
            }
            currDepthNodes = nextDepthNodes;
        }
        return result;
    }

    public static List<List<Integer>> binaryTreeDepthOrder(BinaryTree<Integer> tree) {
        List<List<Integer>> ans = new ArrayList<>();
        if (tree == null) {
            return ans;
        }
        Queue<BinaryTree<Integer>> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                BinaryTree<Integer> removed = queue.remove();
                temp.add(removed.data);
                if (removed.left != null) {
                    queue.add(removed.left);
                }
                if (removed.right != null) {
                    queue.add(removed.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
