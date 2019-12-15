import java.util.HashMap;
import java.util.Map;

public class FindOverlappingWithCycles {

    /*
    8.5
    The listsoverlap if and only if both have the same tail node: once the lists converge
at a node, they cannotdiverge at a later node. Therefore, checking for overlap amounts
to finding the tail nodesfor each list.
To find the first overlapping node, we first compute the length of each list. The
first overlapping node is determined by advancing through the longer list by the
difference in lengths, and then advancing through both lists in tandem, stopping at
the first common node. If we reach the end of a list without finding a common node,
the lists do not overlap.

    The time complexity is0(n) and the space complexity is0(1).
    */

    public static ListNode<Integer> overlappingNoCycleLists(
            ListNode<Integer> LI, ListNode<Integer> L2) {
        int LILength = length(Ll), L2Length = length(L2);
// Advances the longer list to get equal length lists.
        if (LILength > L2Length) {
            LI = advanceListByK(LILength - L2Length, LI);
        } else {
            L2 = advanceListByK(L2Length - LILength, L2);
        }
        while (LI != null && L2 != null && LI != L2){
            LI = LI.next;
            L2 = L2.next;
        }
        return LI; // nullptr implies there is no overlap between LI and L2.
    }

    public static ListNode<Integer> advanceListByK(int k, ListNode<Integer> L) {
        while (k-- > 0) {
            L = L.next;
        }
        return L;
    }

    private static int length(ListNode<Integer> L) {
        int len = 0;
        while (L != null) {
            ++len;
            L = L.next;
        }
        return len;
    }
}
