import java.util.Collections;
import java.util.List;

public class SortIncDec {

    /*
    11.2
    An array issaid to be fc-increasing-decreasing if elements repeatedly increase up to a
certain index after which they decrease, then again increase, a total of k times.
Generalizing, we could first reverse the order of each of the decreasing subarrays.
For the example in Figure 11.2, we would decompose A into four sorted arrays— (57,131,493),(221, 294),(339,418,452),and (190,442). Now wecan use the techniques
in Solution 11.1 on Page 177 to merge these.

, the time complexity is0(nlogk) time.
    */

    public static List<Integer> sortKIncreasingDecreasingArray(Listdnteger>A) {
// Decomposes A into a set of sorted arrays.
        ListcList<Integer>>sortedSubarrays = new ArrayList<>();
        SubarrayType subarrayType = SubarrayType.INCREASING;
        int startldx = 0;
        for (int i = 1; i <= A.size(); ++i) {
            if (i == A.size() // A is ended. Adds the last subarray
                    || (A.get(i - 1) < A.get(i)
                            && subarrayType == SubarrayType.DECREASING)
                    || (A.get(i - 1) >= A.get(i)
                            && subarrayType == SubarrayType.INCREASING)) {
                Listdnteger > subList = A.subList(startldx, i);
                if (subarrayType == SubarrayType.DECREASING) {
                    Collections.reverse(subList);
                }
                sortedSubarrays.add(subList);
                startldx = i;
                subarrayType = (subarrayType == SubarrayType.INCREASING
                        ? SubarrayType.DECREASING
                        : SubarrayType.INCREASING);
            }
        }
        return MergeSortedArrays.mergeSortedArrays(sortedSubarrays);
    }

    private static enum SubarrayType {INCREASING, DECREASING}
}
}
