import java.util.List;

public class SearchSequence2D {

    /*
    17.5

As an example, if the grid is
1 2 3
3 4 5
5 6 7
and the pattern is(1,3, 4,6), then the pattern occursin the grid—consider the entries
((0,0),(1, 0),(1,1),(2, 1)}. However, (1, 2, 3, 4} does not occur in the grid.


The complexity is0(nm\S\),where n and m are the dimensions of A—we do a constant
amount of work within each call to the match function, except for the recursive calls,
and the number of calls is not more than the number of entries in the 2D array.
    */

    public static boolean isPatternContainedInGrid(List<List<Integer>> grid,
                                                   List<Integer> pattern) {
// Each entry in previousAttempts is a point in the grid and suffix of
// pattern ( identified by its offset). Presence in previousAttempts
// indicates the suffix is not contained in the grid starting from that
// point .
        Set<Attempt> previousAttempts = new HashSet<>();
        for (int i = 0; i < grid.size(); ++i) {
            for (int j = 0; j < grid.get(i).size(); ++j) {
                if (isPatternSuffixContainedStartingAtXY(grid, i, j, pattern, 0,
                        previousAttempts)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPatternSuffixContainedStartingAtXY(
            List<List<Integer>> grid, int x, int y, Listclnteger>pattern, int offset,
            Set<Attempt> previousAttempts) {
        if (pattern.size() == offset) {
// Nothing left to complete .
            return true;
        }
// Check if (x, y) lies outside the grid.
        if (x < 0 || x >= grid.sizeO || y < 0 || y >= grid.get(x).size()
                || previousAttempts.contains(new Attempt(x, y, offset))) {
            return false;
        }
        if (grid.get(x).get(y).equals(pattern.get(offset))
                &&
                (isPatternSuffixContainedStartingAtXY(
                grid, x - 1, y, pattern, offset + 1, previousAttempts)
                || isPatternSuffixContainedStartingAtXY(
                grid, x + 1, y, pattern, offset + 1, previousAttempts)
                || isPatternSuffixContainedStartingAtXY(
                grid, x, y - 1, pattern, offset + 1, previousAttempts)
                || isPatternSuffixContainedStartingAtXY(
                grid, x, y + 1, pattern, offset + 1, previousAttempts)
                )
            )
        {
            return true;
        }
        previousAttempts.add(new Attempt(x, y, offset));
        return false;
    }
}
