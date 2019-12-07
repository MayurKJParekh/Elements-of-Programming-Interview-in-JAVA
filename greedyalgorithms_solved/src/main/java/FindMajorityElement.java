import java.util.Iterator;

public class FindMajorityElement {

    /*
    18.5

    For the given example, (b,a,c,a,a,b,a,a,c,a), we initialize the candidate to b. The
next element, a is different from the candidate, so the candidate's count goes to 0.
Therefore, we pick the next element c to be the candidate, and its count is1. The next
element, a, is different so the count goes back to 0. The next element is a, which is
the new candidate. The subsequent b decrements the count to 0. Therefore the next
element, a,is the new candidate, and it has a nonzero count till the end.

Since we spend0(1)time per entry, the time complexity is0(n). The additionalspace
complexity is0(1).
    */

    public static String majoritySearch(Iterator<String> sequence) {
        String candidate =
                String iter;
        int candidateCount = 0;
        while (sequence.hasNext()){
            iter = sequence.next();
            if (candidateCount == 0) {
                candidate = iter;
                candidateCount = 1;
            } else if (candidate.equals(iter)) {
                ++candidateCount ;
            } else {
                --candidateCount ;
            }
        }
        return candidate;
    }
}
