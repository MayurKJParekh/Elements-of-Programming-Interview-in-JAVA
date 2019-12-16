import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SortAlmostSorted {

    /*
    11.3
    Write a program which takes as input a very long sequence of numbers and prints
the numbersin sorted order. Each number is at most k away from its correctly sorted
position. (Such an array issometimes referred to as being For example, no
number in the sequence (3,-1,2,6,4,5,8} is more than 2 away from its final sorted
position.


    */

    public static void sortApproximatelySortedData(Iterator<Integer> sequence,
                                                   int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
// Adds the first k elements into minHeap. Stop if there are fewer than k
// elements .
        for (int i = 0; i < k && sequence.hasNext(); ++i) {
            minHeap.add(sequence.next());
        }

// For every new element, add it to minHeap and extract the smallest.
        while (sequence.hasNext()) {
            minHeap.add(sequence.next());
            Integer smallest = minHeap.remove();
            System.out.println(smallest);
        }

// sequence is exhausted, iteratively extracts the remaining elements.
        while (!minHeap.isEmpty()) {
            Integer smallest = minHeap.remove();
            System.out.println(smallest);
        }

    }

}
