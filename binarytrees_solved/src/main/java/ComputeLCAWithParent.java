public class ComputeLCAWithParent {

    /*
    10.4

    The time and space complexity are that of computing the depth, namely 0(h) and
0(1),respectively.
    */

    public static BinaryTree<Integer> LCA (BinaryTree <Integer > node0,
                                           BinaryTree <Integer > node1) {
        int depth0 = getDepth(node0), depth1 = getDepth(node1);
// Makes node(9 as the deeper node in order to simplify the code.
        if (depth1 > depth0) {
            BinaryTree<Integer> temp = node0;
            node0 = node 1;
            node1 = temp;
        }

// Ascends from the deeper node.
        int depthDiff = Math.abs(depth0 - depth1);
        while (depthDiff-- > 0) {
            node0 = node0.parent;
        }

// Now ascends both nodes until we reach the LCA.
        while (node0 != node1) {
            node0 = node0.parent;
            node1 = node1.parent;
        }
        return node0;
    }

    private static int getDepth(BinaryTree<Integer> node) {
        int depth = 0;
        while (node.parent != null) {
            ++depth ;
            node = node. parent;
        }
        return depth;
    }
}
