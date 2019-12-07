import java.util.List;

public class MakingWiredConnections {

    /*
    19.6

    Solution: A brute-force approach might be to try all partitions of the pins into two
sets. However, the number of such partitionsis very high.
A better approach is to use connectivity information to guide the partitioning.
Assume the pins are numbered from 0 to p -1. Create an undirected graph G whose
vertices are the pins. Add an edge between pairs of verticesif the corresponding pins
are connected by a wire. For simplicity, assume G is connected; if not, the connected
components can be analyzed independently.
Run BFS on G beginning with any vertex v0. Assign v0 arbitrarily to lie on the left
half. All vertices at an odd distance from Vo are assigned to the right half.

The complexity is the same as for BFS, i.e., 0(p + tv) time complexity, where tv is the
number of wires, and 0(p)space complexity
    */

    public static class GraphVertex {
        public int d = -1;
        public List<GraphVertex> edges = new ArrayList<>();

        public static boolean isAnyPlacementFeasible(List<GraphVertex> G) {
            for (GraphVertex v : G) {
                if (v.d == -1) { // Unvisited vertex.
                    v.d =0;
                    if (!BFS(v)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private static boolean BFS(GraphVertex s) {
            Queue<GraphVertex> q = new LinkedList<>();
            q.add(s);
            while (!q.isEmpty()) {
                for (GraphVertex t : q.peek().edges) {
                    if (t.d == -1) { // Unvisited vertex.
                        t.d = q.peek().d + 1;
                        q.add(t);
                    } else if (t.d == q.peek().d) {
                        return false;
                    }
                }
                q.remove();
            }
            return true;
        }
    }
