import java.util.List;

public class AdvanceThroughArray {

    /*
       6.4
    */

    public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
        int furthestReachSoFar = 0, lastlndex = maxAdvanceSteps.size() - 1;
        for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastlndex;
             ++i) {
            furthestReachSoFar
                    = Math.max(furthestReachSoFar, i + maxAdvanceSteps.get(i));
        }
        return furthestReachSoFar >= lastlndex;
    }

    //Time Complexity: O(n^2)
    private static int minJumps(int[] arr, int n) {
        int jumps[] = new int[n]; // jumps[n-1] will hold the
        // result
        int i, j;

        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE; // if first element is 0,
        // end cannot be reached

        jumps[0] = 0;

        // Find the minimum number of jumps to reach arr[i]
        // from arr[0], and assign this value to jumps[i]
        for (i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
    }
}
