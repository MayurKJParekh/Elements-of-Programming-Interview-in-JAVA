public class RealSquareRoot {

    /*
    12.5

    Let x be the input. One approach isto find an integer n such that n2 < x and
( n + l)2 > x, using, for example, the approach in Solution 12.4 on the facing page. We
can then search within [n,n+1] to find the square root of x to any specified tolerance.
We can avoid decomposing the computation into an integer computation followed
by a floating point computation by directly performing binary search. The reason is
that if a number istoo big to be the square root of x, then any number bigger than that
number can be eliminated. Similarly, if a number is too small to be the square root of
x, then any numbersmaller than that number can be eliminated.
Trivial choices for the initial lower bound and upper bound are 0 and the largest
floating point number that is representable. The problem with thisis that it does not
play well with finite precision arithmetic—the first midpoint itself will overflow on
squaring.
We cannot start with [0,x] because the square root may be larger than x, e.g.,
Vl/4 = 1/2. However, if x > 1.0, we can tighten the lower and upper bounds to 1.0
and x, respectively, since if 1.0 < x then x < x2. On the other hand, if x < 1.0, we
can use x and 1.0 as the lower and upper bounds respectively, since then the square
root of x is greater than x but less than 1.0. Note that the floating point square root
problem differs in a fundamental way from the integersquare root (Problem 12.4 on
the preceding page). In that problem, the initial interval containing the solution is
always[0,x].
    */

    public static double squareRoot(double x) {
// Decides the search range according to x’s value relative to 1.(9.
        double left, right;
        if (x < 1.0) {
            left = x;
            right = 1.0;
        } else { // x >= 1.<9.
            left = 1.0;
            right = x;
        }
// Keeps searching as long as left < right , within tolerance.
        while (compare(left, right) == Ordering.SMALLER) {
            double mid = left + 0.5 * (right - left);
            double midSquared = mid * mid;
            if (compare(midSquared, x) == Ordering.EQUAL) {
                return mid;
            } else if (compare(midSquared, x) == Ordering.LARGER) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private static enum Ordering {SMALLER, EQUAL, LARGER}

    private static Ordering compare(double a, double b) {
        final double EPSILON = 0.00001;
// Uses normalization for precision problem.
        double diff = (a - b) / b;
        return diff < -EPSILON
                ? Ordering.SMALLER
                : (diff > EPSILON ? Ordering.LARGER : Ordering.EQUAL);
    }
}
