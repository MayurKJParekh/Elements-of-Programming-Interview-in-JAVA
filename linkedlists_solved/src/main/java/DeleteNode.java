public class DeleteNode {

    /*
    8.6
    */

    public static void deletionFromList(ListNode<Integer> nodeToDelete) {
        nodeToDelete.data = nodeToDelete.next.data ;
        nodeToDelete.next = nodeToDelete.next.next ;
    }

}
