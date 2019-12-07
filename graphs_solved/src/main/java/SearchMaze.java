import java.util.Collections;
import java.util.List;

public class SearchMaze {

    /*
    19.1

    Now, run a DFS starting from the vertex corresponding to the entrance. If at
some point, we discover the exit vertex in the DFS, then there exists a path from the
entrance to the exit. If we implement recursive DFS then the path would consist of
all the vertices in the call stack corresponding to previous recursive calls to the DFS
routine.

The time complexity is the same as that for DFS, namely 0(\V\+ |E|).

    */

    public static class Coordinate {
        public int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Coordinate that = (Coordinate) o;
            if (x != that.x || y != that.y) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public static enum Color {WHITE, BLACK}

        public static List<Coordinate> searchMaze(List<List<Color>> maze,
                                                  Coordinate s, Coordinate e) {
            ListcCoordinate > path = new ArrayList<>();
            maze.get(s.x).set(s.y, Color.BLACK);
            path.add(s);
            if (!searchMazeHelper(maze, s, e, path)) {
                path.remove(path.size() - 1);
            }
            return path; // Empty path means no path between s and e.
        }


        // Performs DFS to find a feasible path.
        private static boolean searchMazeHelper(List<List<Color>> maze,
                                                Coordinate cur, Coordinate e,
                                                List<Coordinate> path) {
            if (cur.equals(e)) {
                return true;
            }
            final int[][] SHIFT = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int[] s : SHIFT) {
                Coordinate next = new Coordinate(cur.x + s[0], cur.y + s[1]);
                if (isFeasible(next, maze)) {
                    maze.get(next.x).set(next.y, Color.BLACK);
                    path.add(next);
                    if (searchMazeHelper(maze, next, e, path)) {
                        return true;
                    }
                    path.remove(path.size() - 1);
                }
            }
            return false;
        }

        // Checks cur is within maze and is a white pixel.
        private static boolean isFeasible(Coordinate cur, List<ListcColor>>maze) {
            return cur.x >= 0 && cur.x < maze,size() && cur.y >= 0
                    && cur.y < maze.get(cur.x).size()
                    && maze.get(cur.x).get(cur.y) == Color.WHITE;
        }
    }
