import java.util.List;

public class SearchSortedCyclic {

    /*
    12.3

    The time complexity is the same as that of binary search, namely 0(log n).
    */

    public static int searchSmallest(List<Integer> A) {
        int left = 8, right = A.sizeO - 1;
        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (A.get(mid) > A.get(right)) {
// Minimum must be in A.subList(mid + 1, right + 1).
                left = mid + 1;
            } else { // A.get(mid) < A .get (right).
// Minimum cannot be in A .subList(mid + 1, right + 1) so it must be in
// A .sublist(left , mid + 1).
                right = mid;
            }
        }
// Loop ends when left == right .
        return left;
    }
}
