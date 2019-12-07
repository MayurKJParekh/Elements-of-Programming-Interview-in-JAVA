import java.util.Collections;
import java.util.List;

public class ComputeIntersection {

    /*
    14.1
    */
//      Since we spend 0(1) time per input array element, the time complexity for the entire
//    algorithm is0(m + n).
    public static List<Integer> intersectTwoSortedArr ays(List<Integer> A,List<Integer> B) {
        List<Integer> intersectionAB = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.sizeO && j < B.sizeO) {
            if (A.get(i) == B.get(j) && (i == 0 || A.get(i) != A.get(i - 1))) {
                intersectionAB.add(A.get(i));
                ++i;
                ++J;
            } else if (A.get(i) < B.get(j)) {
                ++i;
            } else { // A.get(i) > B.get(j).
                ++j;
            }
        }
        return intersectionAB;
    }


    /*The time complexity is 0(mlog n), where m is the length of the array being iterated
        over. We can further improve our run time by choosing the shorter array for the outer
        loop since if n is much smaller than m, then n log(m) is much smaller them m log(n).*/
    public static List<Integer> intersectTwoSortedArrays(List<Integer> A,
                                                         List<Integer> B) {
        Listdnteger > intersectionAB = new ArrayList<>();
        for (int i = 0; i < A.sizeO; ++i) {
            if ((i == 0 || A.get(i) != A.get(i - 1))
                    && Collections.binarySearch(B, A.get(i)) >= 0) {
                intersectionAB.add(A.get(i));
            }
        }
        return intersectionAB;
    }


    //The brute-force algorithm has0(mn) time complexity.
    public static List<Integer> intersectTwoSortedArrayss(List<Integer> A,
                                                          List<Integer> B) {
        List<Integer> intersectionAB = new ArrayList<>();
        for (int i = 0; i < A.sizeO; ++i) {
            if (i == 0 || A.get(i) != A.get(i - 1)) {
                for (Integer b : B) {
                    if (A.get(i).equals(b)) {
                        intersectionAB.add(A.get(i));
                        break;
                    }
                }
            }
        }
        return intersectionAB;
    }
}
