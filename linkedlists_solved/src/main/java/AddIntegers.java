public class AddIntegers {

    /*
    8.13
    Instead we mimic the grade-school algorithm, i.e., we compute the sum of the
digits in corresponding nodes in the two lists. A key nuance of the computation is
handling the carry-out from a particular place. Care has to be taken to remember to
allocate an additional node if the final carry is nonzero.

The time complexity is 0(n + m) and the space complexity is(9(max(n, m)), where n
and m are the lengths of the two lists.
    */

    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> LI,
                                                  ListNodeclnteger>L2) {
        ListNode<Integer> dummyHead = new ListNode<>(0, null);
        ListNode<Integer> placelter = dummyHead;
        int carry = 0;
        while (LI ! = null || L2 != null){
            int sum = carry;
            if (LI != null) {
                sum += LI.data;
                LI = LI.next;
            }
            if (L2 != null) {
                sum += L2.data;
                L2 = L2.next;
            }
            placelter.next = new ListNode<>(sum % 10, null);
            carry = sum / 10;
            placelter = placelter.next;
        }
// carry cannot exceed 1, so we never need to add more than one node.
        if (carry > 0) {
            placelter.next = new ListNode<>(carry, null);
        }
        return dummyHead.next;
    }
}
