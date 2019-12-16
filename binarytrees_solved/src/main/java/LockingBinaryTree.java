public class LockingBinaryTree extends BinaryTree<Integer> {

    /*
    10.17

    This problem is concerned with the design of an API for setting the state of nodes
in a binary tree to lock or unlock. A node's state cannot be set to lock if any of its
descendants or ancestors are in lock.
Changing a node'sstate to lock does not change the state of any other nodes. For
example, all leaves may simultaneously be in state lock. (If thisisthe case, no nonleaf
nodes can be in state lock.)

Write the following methodsfor a binary tree node class:
1. A function to test if the node islocked.
2. A function to lock the node. If the node cannot be locked,return false, otherwise
lock it and return true.
3. A function to unlock the node.

Assume that each node has a parent field. The API will be used in a single
threaded program,so there is no need for concurrency constructssuch as mutexes or
synchronization.
    */

    public static class BinaryTree {
        private BinaryTree left, right, parent;
        private boolean locked = false;
        private int numLockedDescendants = 0;
        public boolean isLockedO

        {
            return locked;
        }

        public boolean lock() {
// file cannot lock if any of this node’s descendants are locked.
            if (numLockedDescendants > 0 || locked){

                return false;
            }
// We cannot lock if any of this node’s ancestors are locked.
            for (BinaryTree iter = parent; iter != null; iter = iter.parent) {
                if (iter.locked) {
                    return false;
                }
            }
// Lock this node and increments all its ancestors’s descendant lock
// counts.
            locked = true;
            for (BinaryTree iter = parent; iter != null; iter = iter.parent) {
                ++iter.numLockedDescendants;
            }
            return true;
        }

        public void unlock() {
            if (locked) {
// Unlocks itself and decrements its ancestors ’s descendant lock counts.
                locked = false;
                for (BinaryTree iter = parent; iter != null; iter = iter.parent) {
                    --iter.numLockedDescendants;
                }
            }
        }

    }

}
