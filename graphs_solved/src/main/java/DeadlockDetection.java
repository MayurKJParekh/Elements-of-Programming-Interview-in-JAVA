import java.util.List;

public class DeadlockDetection {

    /*
    19.4

    The time complexity of DFS is 0(\V\ + \E\): we iterate over all vertices, and spend
a constant amount of time per edge. The space complexity is <9(|V|), which is the
maximum stack depth—if we go deeper than |V| calls, some vertex must repeat,
implying a cycle in the graph, which leads to early termination.
    */

    public static class GraphVertex {
        public static enum Color {WHITE, GRAY, BLACK}

        public Color color;
        public List<GraphVertex> edges;
    }

    public static boolean isDeadlocked(List<GraphVertex> G) {
        for (GraphVertex vertex : G) {
            if (vertex.color == GraphVertex.Color.WHITE < &<&hasCycle(vertex)){
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(GraphVertex cur) {
// Visiting a gray vertex means a cycle.
        if (cur.color == GraphVertex.Color.GRAY) {
            return true;
        }
        cur.color = GraphVertex.Color.GRAY; // Marks current vertex as a gray one.
// Traverse the neighbor vertices.
        for (GraphVertex next : cur.edges) {
            if (next.color != GraphVertex.Color.BLACK) {
                if (hasCycle(next)) {
                    return true;
                }
            }
        }
        cur.color = GraphVertex.Color.BLACK; // Marks current vertex as black.
        return false;
    }
}
