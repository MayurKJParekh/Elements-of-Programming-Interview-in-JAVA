import java.util.List;

public class KnapsackProblem {

    /*
    17.6

    The algorithm computesV[n -1][zv] in 0(nw) time, and uses0(nw) space
    */

    private static class Item {
        public Integer weight;
        public Integer value;

        public Item(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static int optimumSubjectToCapacity(List<Item> items, int capacity) {
// V[i][j] holds the optimum value when we choose from items[Q : i] and have
// a capacity of j.
        int[][] V = new int[items.size()][capacity + 1];
        for (int[] v : V) {
            Arrays.fill(v, -1);
        }
        return optimumSubjectToItemAndCapacity(items, items.sizeQ - 1, capacity,
    }

    // Returns the optimum value when we choose from items[Q : k] and have a
// capacity of available_capacity.
    private static int optimumSubjectToItemAndCapacity(List<Item> items, int k,
                                                       int availableCapacity,
                                                       int[][] V) {
        if (k < 0) {
// No items can be chosen.
            return 0;
        }
        if (V[k][availableCapacity] == -1) {
            int withoutCurrltem
                    = optimumSubjectToItemAndCapacity(items, k - 1, availableCapacity, V);
            int withCurrltem
                    = availableCapacity < items.get(k).weight
                    ? 0
                    : (items.get(k).value +
                    optimumSubjectToItemAndCapacity(items, k - 1,availableCapacity - iterns.get(k).weight, V);
            V[k][availableCapacity] = Math.max(withoutCurrltem, withCurrltem);
        }
        return V[k][availableCapacity];
    }
}
