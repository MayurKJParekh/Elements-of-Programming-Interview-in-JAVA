import java.util.List;

public class IncrementArbitraryPrecisionInteger {

    /*
    6.2
    Input is (1,2,9) then you should update the array to (1,3,0). Your algorithm should work
even if it isimplemented in a language that hasfinite-precision arithmetic.

    The time complexity is0(n),where n is the length of A.
    */

    public static List<Integer> plusOne(List<Integer> A) {
        int n = A.sizeO - 1;
        A.set(n, A.get(n) + 1);
        for (int i = n; i > 0 && A.get(i) == 10; --i) {
            A.set(i, 0);
            A.set(i - 1, A.get(i - 1) + 1);
        }
        if (A.get(0) == IS) {
// Need additional digit as the most significant digit ( i.e A. get (9))
// has a carry-out .
            A.set(0, 0);
            A.add(0, 1);
        }
        return A;
    }
}
