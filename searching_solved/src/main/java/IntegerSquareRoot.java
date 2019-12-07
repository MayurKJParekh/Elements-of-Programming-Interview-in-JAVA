public class IntegerSquareRoot {

    /*
    12.4

    For fc = 25, the sequence of intervals is [0, 25],[0,11],[6,11],[6, 7],[6,5], The re¬
turned value is 6-1 =5.


The time complexity is that of binary search over the interval [0,fc], i.e.,O(logk).
    */

    public static int squareRoot(int k) {
        long left =0,right = k;
// Candidate interval [left, right] where everything before left has
// square <= k, and everything after right has square > k.
        while (left <= right) {
            long mid = left + ((right - left) / 2);
            long midSquared = mid * mid;
            if (midSquared <= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) left - 1;
    }
}
