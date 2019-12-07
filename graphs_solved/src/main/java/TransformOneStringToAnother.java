import java.util.Set;

public class TransformOneStringToAnother {

    /*
    19.7

    Solution: A brute-force approach may be to explore all strings that differ in one
character from the starting string, then two characters from the starting string, etc.
The problem with this approach is that it may explore lots of strings that are outside
the dictionary.
A better approach is to be more focused on dictionary words. In particular, it's
natural to model this problem using graphs. The vertices correspond to stringsfrom
the dictionary and the edge («, v) indicates that the strings corresponding to u and
v differ in exactly one character. Note that the relation "differs in one character" is
symmetric,so the graph is undirected.
For the given example, the vertices would be {bat, cot,dog,dag,dot,cat), and the
edges would be {(bat, cat),(cot,dot),(cot, cat),(dog,dag),(dog,dot)).
A production sequence is simply a path in G, so what we need is a shortest path
from s to t in G. Shortest pathsin an undirected graph are naturally computed using
BFS.
    */

    private static class StringWithDistance {
        public String candidatestring;
        public Integer distance;

        public StringWithDistance(String candidatestring, Integer distance) {
            this.candidatestring = candidatestring;
            this.distance = distance;
        }
    }

    // Uses BFS to find the least steps of transformation.
    public static int transformstring(Set<String> D, String s, String t) {
        Queue<StringWithDistance> q = new LinkedList<>();
        D.remove(s); // Marks s as visited by erasing it in D.
        q.add(new StringWithDistance(s, 0));
        StringWithDistance f;
        while ((f = q.poll())!=null){
// Returns if we find a match.
            if (f.candidatestring.equals(t)) {
                return f.distance; // Number of steps reaches t.
            }
// Tries all possible transformations of f.first.
            String str = f.candidatestring;
            for (int i =0;
            i<str.length (); ++i){
                String strStart = i ==0?"":str.substring(0 , i);
                String strEnd = i + 1 < str.length() ? str.substring(i + 1) :
                for (int j =0;j< 26;++j){ // Iterates through ’a’ ~ ’z’.
                    String modStr = strStart + (char) ('a'+j)+strEnd;
                    if (D.remove(modStr)) {
                        q.add(new StringWithDistance(modStr, f.distance + 1));
                    }
                }
            }
        }
        return -1; // Cannot find a possible transformations.
    }
}
