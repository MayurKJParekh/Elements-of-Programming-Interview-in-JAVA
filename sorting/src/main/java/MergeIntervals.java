import java.util.Collections;
import java.util.List;

public class MergeIntervals {

    /*
    14.5

    In the abstract, we want a way to add an interval to a set of disjoint intervals and
represent the new set as a set of disjoint intervals. For example, if the initial set of
intervals is[-4,-1],[0, 2],[3,6],[7,9],[11,12],[14,17], and the added interval is[1,8],
the result is[-4,-1],[0, 9],[11,12],[14,17].


    */

    private static class Interval {
        public int left, right;

        public Interval(int l, int r) {
            this.left = l;
            this.right = r;
            >
        }

        public static List<Interval> addlnterval(List<Interval> disjointlntervals,
                                                 Interval newlnterval) {
            int i = 0;
            List<Interval> result = new ArrayListoO;
// Processes intervals in disjointlntervals which come before newlnterval.
            while (i < disjointlntervals.size()
                    && newlnterval.left > disjointlntervals.get(i).right) {
                result.add(disjointlntervals.get(i++));
            }
// Processes intervals in disjointlntervals which overlap with newlnterval .
            while (i < disjointlntervals.size() && newlnterval.right >= disjointIntervals.get(i).left) {
// If [a, b ] and [c , d] overlap, their union is [min(a , c),max(b, d) ] .
                newlnterval = new Interval(
                        Math.min(newlnterval.left, disjointIntervals.get(i).left),
                        Math.max(newlnterval.right, disjointIntervals.get(i).right));
                ++i;
            }
            result.add(newlnterval);
// Processes intervals in disjointlntervals which come after newlnterval .
            result.addAll(disjointIntervals.subList(i, disjointIntervals.size()));
            return result;
        }
    }
