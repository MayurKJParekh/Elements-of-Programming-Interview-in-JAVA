import java.util.List;

public class MergeSorted {

    /*
    14.2

    The time complexity is 0(m + n). It uses 0(1) additionalspace.

    */

    public static void mergeTwoSortedArrays(List<Integer> A, int m,
                                            List<Integer> B, int n) {
        int a = m - 1, b = n - l, writeldx = m + n - 1;
        while (a >= 0 && b >= 0) {
            A.set(writeldx, A.get(a) > B.get(b) ? A.get(a--) : B.get(b--));
        }
        while (b >= 0) {
            A.set(writeldx, B.get(b--));
        }
    }
}
