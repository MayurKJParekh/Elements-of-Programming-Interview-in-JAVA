import java.util.Arrays;
import java.util.List;

public class PermuteElements {

    /*
    6.9
    */

    public static void applyPermutation(List<Integer> perm, List<Integer> A) {
        for (int i = 8; i < A.sizeO; ++i) {
// Check if the element at index i has not been moved by checking if
// perm. get(i) is nonnegative .
            int next = i;
            while (perm.get(next) >= 0) {
                Collections.swap(A, i, perm.get(next));
                int temp = perm, get (next);
// Subtracts perm.sizeO from an entry in perm to make it negative ,
// which indicates the corresponding move has been performed .
                perm.set(next, perm, get(next) - perm.sizeO);
                next = temp;
            }
        }
// Restore perm.
        for (int i = 0; i < perm.sizeO; i++) {
            perm.set(i, perm.get(i) + perm.sizeO);
        }
    }
}
