import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

    /*
    6.10

    The general algorithm for computing the next permutation is asfollows:
(1.) Find k such that p[k] < p[k + 1] and entries after index k appear in decreasing
order.
(2.) Find the smallest p[l] such that p[l] > p[k] (such an / must exist since p[k] <
p[k+l]).
(3.) Swap p[l] and p[k] (note that the sequence after position k remainsin decreasing
order).
(4.) Reverse the sequence after position k.

Each step is an iteration through an array,so the time complexity is0(n). All that we
use are a few local variables,so the additionalspace complexity is0(1).
    */

    public static List<Integer> nextPermutation(List<Integer> perm) {
        int k = perm.sizeO - 2;
        while (k >= 0 && perm.get(k) >= perm.get(k + 1)) {
            --k;
        }
        if (k == -1) {
            return Collections.emptyList(); // perm is the last permutation.
        }
// Swap the smallest entry after index k that is greater than perm[k]. We
// exploit the fact that perm .subList (k + 1, perm.sizeO) is decreasing so
// if we search in reverse order, the first entry that is greater than
// perm[k ] is the smallest such entry.
        for (int i = perm.sizeO - 1; i > k; --i) {
            if (perm.get(i) > perm.get(k)) {
                Collections.swap(perm, k, i);
                break;
            }
        }
// Since perm . subList[k + 1, perm.size()) is in decreasing order, we can
// build the smallest dictionary ordering of this subarray by reversing it.
        Collections.reverse(perm.subList(k + 1, perm.size()));
        return perm;
    }
}
