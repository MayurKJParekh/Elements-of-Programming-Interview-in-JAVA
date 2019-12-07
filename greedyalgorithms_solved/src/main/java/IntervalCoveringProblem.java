import java.util.Collections;
import java.util.List;

public class IntervalCoveringProblem {

    /*
    18.3

    For the given example, [1,2],[2,3],[3,4],[2,3],[3,4],[4,5], after sorting on right
endpoints we get[1, 2],[2,3],[2,3],[3,4],[3,4],[4,5], The leftmost right endpoint is 2,
which covers the first three intervals. Therefore, we select 2, and as we iterate, we see
it covers [1, 2],[2,3],[2,3], When we get to [3,4], we select its right endpoint, i.e., 4.
This covers[3,4],[3,4],[4,5]. There are no remaining intervals,so (2,4] is a minimum
set of points covering all intervals.

Since we spend (9(1) time per index, the time complexity after the initialsort is0(n),
where n is the number of intervals Therefore, the time taken is dominated by the
initial sort, i.e.,0(n log n).
    */

    public static class Interval {
        public int left, right;
        public Interval(int 1, int r) {
            this.left = 1;
            this.right = r;
        }
    }
    public static List<Integer> findMinimumVisits(List<Interval> intervals) {
        if (intervals.isEmptyO) {
            return Collections.EMPTY_LIST;
        }

        // Sort intervals based on the right endpoints.
        Collections.sort(intervals, new Comparatordnterval > () {
            @Override
            public int compare (Interval il, Interval i2){
                return Integer.compare(i1.right, i2.right);
            }
        });
        List<Integer> visits = new ArrayList<>();
        Integer lastVisitTime = intervals.get(0).right;
        visits.add(lastVisitTime);
        for (Interval interval : intervals) {
            if (interval.left > lastVisitTime) {
// The current right endpoint , lastVisitTime , will not cover any more
// intervals.
                lastVisitTime = interval.right;
                visits.add(lastVisitTime);
            }
        }
        return visits;
    }
}
