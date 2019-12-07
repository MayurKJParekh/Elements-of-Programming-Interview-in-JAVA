import java.util.List;

public class ComputeLargestRectangle {

    /*
    18.8

    The time complexity is 0(n).
    */

    public static int calculateLargestRectangle(List<Integer> heights) {
        Deque<Integer> pillarlndices = new LinkedList<>();
        int maxRectangleArea = o;
        for (int i = 0; i <= heights.size(); ++i) {
            if (!pillarlndices.isEmpty() && i < heights.size()
                    && heights.get(i).equals(heights.get(pillarIndices.peekFirst()))) {
// Replace earlier building with same height by current building. This
// ensures the later buildings have the correct left endpoint.
                pillarlndices.removeFirst();
                pillarlndices.addFirst(i);
            }
// By iterating to heights.size() instead of heights.size() - 1, we can
// uniformly handle the computation for rectangle area here.
            while (!pillarlndices.isEmpty()
                    && isNewPillarOrReachEnd(heights, i, pillarIndices.peekFirst())) {
                int height = heights.get(pi1larlndices.removeFirst());
                int width = pillarlndices.isEmpty() ? i : i - pillarlndices.peekFirst() - 1;
                maxRectangleArea = Math.max(maxRectangleArea, height * width);
            }
            pillarlndices.addFirst(i);
        }
        return maxRectangleArea;
    }

    private static boolean isNewPillarOrReachEnd(List<Integer> heights,
                                                 int currldx, int lastPillarldx) {
        return currldx < heights.size()
                ? heights.get(currldx) < heights.get(lastPillarldx)
                : true;
    }
}
