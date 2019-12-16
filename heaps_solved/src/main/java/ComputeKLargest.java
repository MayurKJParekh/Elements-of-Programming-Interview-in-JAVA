import java.util.Collections;
import java.util.List;

public class ComputeKLargest {

    /*
    11.6
    The ideal data structure for tracking the index to process next is a data structure
which support fast insertions, and fast extract-max, i.e., in a max-heap. So our
algorithm isto create a max-heap of candidates, initialized to hold the index 0, which
serves as a reference to A[0]. The indices in the max-heap are ordered according to
corresponding value in A. We then iteratively perform k extract-max operationsfrom
the max-heap. Each extraction of an index i is followed by inserting the indices of
i's left child, 2i + 1, and right child, 2i + 2, to the max-heap, assuming these children
exist.

The total number of insertion and extract-max operationsis0(k),yielding an0(k log k)
time complexity, and an 0(k) additional space complexity. This algorithm does not
modify the original heap.
    */

    private static class HeapEntry {
        public Integer index;
        public Integer value;

        public HeapEntry(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }
    }

    private static class Compare implements Comparator<HeapEntry> {
        @Override
        public int compare(HeapEntry ol, HeapEntry o2) {
            return Integer.compare(o2.value, ol.value);
        }

        public static final Compare COMPARE_HEAP_ENTRIES = new Compare();
    }


    private static final int DEFAULT_INITIAL_CAPACITY = 16;


    public static List<Integer> kLargestlnBinaryHeap(List<Integer> A, int k) {
        if (k <= 0){
            return Collections.EMPTY_LIST;
        }

// Stores the (index, value)-pair in candidateMaxHeap. This heap is
// ordered by the value field.
        PriorityQueuecHeapEntry > candidateMaxHeap = new PriorityQueue<>(
                DEFAULT.INITIAL_CAPACITY, Compare.COMPARE_HEAP_ENTRIES);

        candidateMaxHeap.add(new HeapEntry(0, A.get(0)));

        List<Integer> result = new ArrayList<>();
        for (int i =0; i<k ; ++i){
            Integer candidateldx = candidateMaxHeap.peek().index;
            result.add(candidateMaxHeap.remove().value);
            Integer leftChildldx = 2 * candidateldx + 1;
            if (leftChildldx < A.sizeO) {
                candidateMaxHeap.add(new HeapEntry(leftChildldx, A.get(leftChildldx)));
            }
            Integer rightChildldx = 2 * candidateldx + 2;
            if (rightChildldx < A.sizeO) {
                candidateMaxHeap.add(
                        new HeapEntry(rightChildldx, A.get(rightChildldx)));
            }
        }
        return result;
    }
}
