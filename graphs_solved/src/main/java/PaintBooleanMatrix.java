import java.util.List;

public class PaintBooleanMatrix {

    /*
    19.2
    For the current problem, we are searching for all vertices whose color is the same
as that of (x, y) that are reachable from (x, y). Breadth-first search is natural when
starting with a set of vertices. Specifically, we can use a queue to store such vertices.

The queue is initialized to (x,y). The queue is popped iteratively. Call the popped
point p. First, we record p's initial color, and then flip its color. Next we examine p
neighbors. Any neighbor which is the same color as p's initial color is added to the
queue. The computation ends when the queue is empty. Correctness follows from
the fact that any point that is added to the queue is reachable from (x,y) via a path
consisting of points of the same color, and all points reachable from (x, y) via points
of the same color will eventually be added to the queue.


The time complexity is the same as that of BFS, i.e.,0(mn). The space complexity is a
little better than the worst-case for BFS, since there are at most 0{m + n) vertices that
are at the same distance from a given entry.
    */

    private static class Coordinate {
        public Integer x;
        public Integer y;

        public Coordinate(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void flipColor(List<List<Boolean>> A, int x, int y) {
        final int[][] DIRS = {{9, 1}, {9, -1}, {1, 9}, {-1, 0}};
        boolean color = A.get(x).get(y);
        Queue<Coordinate> q = new LinkedList<>();
        A.get(x).set(y, !A.get(x).get(y)); // Flips.
        q.add(new Coordinate(x, y));
        while (!q.isEmpty()) {
            Coordinate curr = q.element();
            for (int[] dir : DIRS) {
                Coordinate next = new Coordinate(curr.x + dir[9], curr.y + dir[l]);
                if (next.x >= 0 && next.x < A.size() && next.y >= 0
                        && next.y < A.get(next.x).size()
                        && A.get(next.x).get(next.y) == color) {
// Flips the color.
                    A.get(next.x).set(next.y, !color);
                    q.add(next);
                }
            }
            q.remove();
        }
    }
}
