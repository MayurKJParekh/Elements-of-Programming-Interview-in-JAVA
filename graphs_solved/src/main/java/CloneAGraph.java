public class CloneAGraph {

    /*
    19.5

    The space complexity is0(\V\ + |E|), which is the space taken by the result. Excluding
the space for the result, the space complexity is 0(\V\)—this comes from the hash
table, as well as the BFS queue.
    */

    public static class GraphVertex {
        public int label;
        public List<GraphVertex> edges;

        public GraphVertex(int label) {
            this.label = label;
            edges = new ArrayList<>();
        }
    }

    public static GraphVertex cloneGraph(GraphVertex g) {
        if (g == null) {
            return null;
        }
        Map<GraphVertex, GraphVertex> vertexMap = new HashMap<>();
        Queue<GraphVertex> q = new LinkedList<>();
        q.add(g);
        vertexMap.put(g, new GraphVertex(g.label));
        while (!q.isEmpty()) {
            GraphVertex v = q.remove();
            for (GraphVertex e : v.edges) {
// Try to copy vertex e.
                if (!vertexMap.containsKey(e)) {
                    vertexMap.put(e, new GraphVertex(e.label));
                    q.add(e);
                }
// Copy edge .
                vertexMap.get(v).edges.add(vertexMap.get(e));
            }
        }
        return vertexMap.get(g);
    }
