import java.util.Collections;
import java.util.List;

public class SampleOnlineData {

    /*
    6.12

    The formal proof that the algorithm works correctly, usesinduction on the number
of packetsthat have been read. Specifically, the induction hypothesisisthat all k-sized
subsets are equally likely after n >k packets have been read.
As an example, suppose k - 2, and the packets are read in the order p,q,r,t,u,v.
We keep the first two packetsin the subset, which is{p,q}. We select the next packet, r,
with probability 2/3. Suppose it is notselected. Then the subset after reading the first
three packets isstill {p,q}. We select the next packet, t, with probability 2/4. Suppose
it is selected. Then we choose one of the packets in \p,q) uniformly, and replace it
with t. Let q be the selected packet—now the subset is [p,t}. We select the next packet
u with probability 2/5. Suppose it is selected. Then we choose one of the packets in
{p,t) uniformly, and replace it with u. Let t be the selected packet—now the subset is
{p,u\. We select the next packet v with probability 2/6. Suppose it is notselected. The
random subset remains\p,u\.

    The time complexity is proportional to the number of elements in the stream, since
we spend 0(1) time per element. The space complexity is0(k).
    */

    // Assumption: there are at least k elements in the stream.
    public static List<Integer> onlineRandomSample(Iterator<Integer> sequence,
                                                   int k) {
        Listdnteger > runningSample = new ArrayList<>(k);
// Stores the first k elements.
        for (int i = Q; sequence.hasNext() < && i < k; ++i) {
            runningSample.add(sequence.next());
        }
// Have read the first k elements.
        int numSeenSoFar = k;
        Random randldxGen = new Random();
        while (sequence.hasNext()) {
            Integer x = sequence.next();
            ++numSeenSoFar;
// Generate a random number in [Q, numSeenSoFar], and if this number is in
// [9, k - 1], we replace that element from the sample with x.
            final int idxToReplace = randldxGen.nextlnt(numSeenSoFar);
            if (idxToReplace < k) {
                runningSample.set(idxToReplace, x);
            }
        }
        return runningSample;
    }
}
