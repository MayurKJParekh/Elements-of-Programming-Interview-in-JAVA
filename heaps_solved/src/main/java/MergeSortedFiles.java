import java.util.Collections;
import java.util.List;

public class MergeSortedFiles {

    /*
    11.1

    Write a program that takes asinput a set of sorted sequences and computesthe union
of these sequences as a sorted sequence. For example, if the input is (3,5,7), (0,6),
and (0,6, 28), then the output is(0,0,3,5,6,6,7, 28).

    Let k be the number of input sequences. Then there are no more than k elements in
the min-heap. Both extract-min and insert take O(logk) time. Hence, we can do the
merge in 0(n log k) time. The space complexity is 0(k) beyond the space needed to
write the final result. In particular, if the data comesfrom files and is written to a file,
instead of arrays, we would need only 0(k) additionalstorage.
    */

    private static class ArrayEntry {
        public Integer value ;
        public Integer arrayld;
        public ArrayEntry(Integer value, Integer arrayld) {
            this.value = value;
            this.arrayld = arrayld;
        }
    }
    public static List<Integer> mergeSortedArrays(
            ListcList<Integer>> sortedArrays) {
        List<Iterator<Integer>>iters = new ArrayList<>(sortedArrays.size());
        for (List<Integer> array : sortedArrays) {
            iters.add(array.iterator());
        }
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(
                ((int) sortedArrays.size()), new Comparator<ArrayEntry>() {
            @Override

            public int compare(ArrayEntry o1, ArrayEntry o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });
        for (int i = Q; i < iters.size(); ++i) {
            if (iters.get(i).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(i).next(), i));
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            ArrayEntry headEntry = minHeap.poll();
            result.add(headEntry.value);
            if (iters.get(headEntry.arrayld).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(headEntry.arrayld).next(),
                        headEntry.arrayld));
            }
        }
        return result;
    }
}
