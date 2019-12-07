import java.util.List;

public class SearchSortedIndex {

    /*
    12.2

    The time complexity is the same as that for binary search , i.e., £?(log n), where n is
the length of A.
    */

    public static int searchEntryEqualToItsIndex(List<Integer> A) {
        int left = 0, right = A.sizeO - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int difference = A.get(mid) - mid;
// A . get (mid) == mid if and only if difference == 0.
            if (difference == 0) {
                return mid;
            } else if (difference > 0) {
                right = mid - 1;
            } else { // difference < 0.
                left = mid + 1;
            }
        }
        return -1;
    }
}
