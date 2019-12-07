import java.util.List;

public class TeamPhotoDay {

    /*
    19.8

    : A team photo. Each team has 11 players, and each player in the back row is taller than the
corresponding player in the front row.

Let G be the DAG with vertices corresponding to the teams asfollows and
edgesfrom vertex X to Y iff Team X can be placed behind Team Y.
Every sequence of teams where a team can be placed behind its predecessor
corresponds to a path in G. To find the longest such sequence, we simply need to
find the longest path in the DAG G. We can do this, for example, by topologically
ordering the vertices in G; the longest path terminating at vertex v is the maximum
of the longest paths terminating at v'sfan-ins concatenated with v itself.

The topological ordering computation is0{\V\ + |E|) and dominates the computation
time. Clearly |V| is the number of teams. The number of edges E depends on the
heights, but can be as high as0(\V\2), e.g., when there is a path of length |V|— 1.
    */

    public static class GraphVertex {
        public List<GraphVertex> edges = new ArrayList<>();
        public int maxDistance = 1;
        public boolean visited = false;
    }

    public static int findLargestNumberTeams(List<GraphVertex> G) {
        Deque<GraphVertex> orderedVertices = buildTopologicalOrdering(G);
        return findLongestPath(orderedVertices);
    }

    private static Deque<GraphVertex> buildTopologicalOrdering(
            List<GraphVertex> G) {
        Deque<GraphVertex> orderedVertices = new LinkedList<>();
        for (GraphVertex g : G) {
            if (!g.visited) {
                DFS(g, orderedVertices);
            }
        }
        return orderedVertices;
    }

    private static int findLongestPath(Deque<GraphVertex> orderedVertices) {
        int maxDistance =0;
        while (!orderedVertices.isEmpty()) {
            GraphVertex u = orderedVertices.peekFirst();
            maxDistance = Math.max(maxDistance, u.maxDistance);
            for (GraphVertex v : u.edges) {
                v.maxDistance = Math.max(v.maxDistance, u.maxDistance + 1);
            }
            orderedVertices.removeFirst();
        }
        return maxDistance;
    }

    private static void DFS(GraphVertex cur, Deque<GraphVertex> orderedVertices) {
        cur.visited = true;
        for (GraphVertex next : cur.edges) {
            if (!next.visited) {
                DFS(next, orderedVertices);
            }
        }
        orderedVertices.addFirst(cur);
    }
}
