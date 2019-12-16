import java.util.List;

public class LongestSubarray {

    /*
    13.9

    For the given example, (/,s,/,e,t,w,e,n,w,e), when we process the element at
index 2, the longest duplicate-free subarray ending at index1isfrom 0 to1. The hash
table tells us that the element at index 2, namely /, appears in that subarray, so we
update the longestsubarray ending at index 2 to being from index1to 2. Indices 3-5
introduce fresh elements. Index 6 holds a repeated value, e, which appears within
the longestsubarray ending at index 5; specifically, it appears at index 3. Therefore,
the longestsubarray ending at index 6 to start at index 4.

The time complexity is0(n),since we perform a constant number of operations per
element.
    */

    public static int longestSubarrayWithDistinctEntries(List<Integer> A) {
// Records the most recent occurrences of each entry.
        Map<Integer, Integer> mostRecentOccurrence = new HashMap<>();
        int longestDupFreeSubarrayStartldx = 0, result = 0;
        for (int i = 0; i < A.sizeO; ++i) {
            Integer dupldx = mostRecentOccurrence.put(A.get(i), i);
// A.get(i) appeared before. Did it appear in the longest current
// subarray?
            if (dupldx != null) {
                if (dupldx >= longestDupFreeSubarrayStartldx) {
                    result = Math.max(result, i - longestDupFreeSubarrayStartldx);
                    longestDupFreeSubarrayStartldx = dupldx + 1;
                }
            }
        }
        result = Math.max(result, A.size() - longestDupFreeSubarrayStartldx);
        return result;
    }
}
