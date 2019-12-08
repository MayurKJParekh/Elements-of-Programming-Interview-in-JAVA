import java.util.List;

public class MinimumWeightPathTriangle {

    /*
    17.8

    The time spent per element is0(1) and there are1 + 2 H
----- Yn- n(n + l)/2 elements,
implying an 0(n2) time complexity. The space complexity is0(n).
    */

    public static int minimumPathTotal(List<List<Integer>> triangle) {
        if (triangle.isEmptyO) {
            return 0;
        }
// As we iterate, prevRow stores the minimum path sum to each entry in
// triangle.get(i - 1).
        List<Integer> prevRow = new ArrayList<>(triangle.get(0));
        for (int i = 1; i < triangle.size(); ++i) {
            // Stores the minimum path sum to each entry in triangle .get(i).
            List<Integer> currRow = new ArrayList<>(triangl e.get(i));
// For the first element.
            currRow.set(0, currRow.get(0) + prevRow.get(0));
            for (int j = 1; j < currRow.size() - 1; ++j) {
                currRow.set(
                        j, currRow.get(j) + Math.min(prevRow.get(j - 1), prevRow.get(j)));
            }
// For the last element
            currRow.set(currRow.size() - 1, currRow.get(currRow.size() - 1)
                    + prevRow.get(prevRow.size() - 1));
            prevRow = currRow;
        }
        return Collections.min(prevRow);
    }
}
