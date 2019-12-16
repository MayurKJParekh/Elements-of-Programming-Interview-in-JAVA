public class ComputeLCA {

    /*
    13.4
    Note that we are trading space for time. The algorithm for Solution 10.4 on Page 157
used0(1)spaceand0(h)time,whereasthe algorithm presented above uses£?(D0+Dl)
space and time, where DO is the distance from the LCA to the first node, and D1 is
the distance from the LCA to the second node. In the worst-case, the nodes are leaves
whose LCA is the root, and we end up using 0(h) space and time, where h is the
height of the tree.
    */

    public static BinaryTree<Integer> LCA(BinaryTree<Integer> node0,
                                          BinaryTree<Integer> node1) {
        Set<BinaryTree<Integer>> hash = new HashSet<>();
        while (node0 != null || nodel != null) {
// Ascend tree in tandem from these two nodes.
            if (node0 != null) {
                if (!hash.add(node0)) {
                    return node0;
                }
                node0 = node0.parent;
            }
            if (node1 != null) {
                if (!hash.add(node1)) {
                    return node1;
                }
                node1 = node1.parent;
            }
        }
        throw new IllegalArgumentException(
                "node® and nodel are not in the same tree");
    }
}
