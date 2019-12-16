public class HeapStack {

    /*
    11.7
    We can use a global 'Timestamp" for each element, which we increment on each
insert. We use this timestamp to order elements in a max-heap. This way the most
recently added element is at the root, which is exactly what we want.

The time complexity for push and pop is that of adding and extracting-max from a
max-heap, i.e., <9(log n), where n is the current number of elements.
    */

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private static class ValueWithRank {
        public Integer value;
        public Integer rank;

        public ValueWithRank(Integer value, Integer rank) {
            this.value = value;
            this.rank = rank;
        }
    }

    private static class Compare implements Comparator<ValueWithRank> {
        @Override
        public int compare(ValueWithRank o1, ValueWithRank o2) {
            return Integer.compare(o2.rank, o1.rank);
        }

        public static final Compare COMPARE
        .VALUEWITHRANK=new

        Compare();
    }

    public static class Stack {
        private int timestamp = 0;

        private PriorityQueue<ValueWithRank> maxHeap = new PriorityQueue<>(
                DEFAULT.INITIAL.CAPACITY, Compare.COMPARE.VALUEWITHRANK);

        public void push(Integer x) {
            maxHeap.add(new ValueWithRank(x, timestamp++));
        }

        public Integer pop() throws NoSuchElementException {
            return maxHeap.remove().value;
        }

        public Integer peek() {
            return maxHeap.peek().value;
        }
    }
}
