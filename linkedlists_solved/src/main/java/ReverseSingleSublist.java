public class ReverseSingleSublist {

    /*
    8.2
    */

    public static ListNode<Integer> reverseSublist(ListNode <Integer> L, int start,
                                                   int finish) {
        if (start == finish) { // No need to reverse since start == finish.
            return L;
        }
        ListNodednteger> dummyHead = new ListNode<>(0 , L);
        ListNodednteger> sublistHead = dummyHead;
        int k = 1;
        while (k++ < start) {
            sublistHead = sublistHead.next ;
        }
// Reverse sublist.
        ListNodednteger> sublistlter = sublistHead.next ;
        while (start++ < finish) {
            ListNode <Integer> temp = sublistlter.next ;
            sublistlter.next = temp.next;
            temp.next = sublistHead.next ;
            sublistHead.next = temp;
        }
        return dummyHead.next ;
    }
}
