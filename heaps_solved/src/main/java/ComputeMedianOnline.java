import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ComputeMedianOnline {

    /*
    11.5
    You want to compute the running median of a sequence of numbers. The sequence is
presented to you in a streaming fashion—you cannot back up to read an earlier value,
and you need to output the median after reading in each new element. For example,
if the input is1,0,3, 5, 2,0,1 the output is 1,0.5,1,2,2,1.5,1.


    */

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public static void onlineMedian(Iterator<Integer> sequence) {
// minHeap stores the larger half seen so far.
        PriorityQueueclnteger > minHeap = new PriorityQueue<>();
// maxHeap stores the smaller half seen so far.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                DEFAULT.INITIAL_CAPACITY, Collections.reverseOrder());

        while (sequence.hasNext()) {
            int x = sequence.next();
            if (minHeap.isEmpty()) {
// This is the very first element.
                minHeap.add(x);
            } else {
                if (x >= minHeap.peek()) {
                    minHeap.add(x);
                } else {
                    maxHeap.add(x);
                }
            }

// Ensure minHeap and maxHeap have equal number of elements if
// an even number of elements is read; otherwise , minHeap must have
// one more element than maxHeap.
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.remove());
            } else if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.remove());
            }

            System.out.println(minHeap.size() == maxHeap.size()
                    ? 0.5 * (minHeap.peek() + maxHeap.peek())
                    : minHeap.peek());
        }
    }
}
