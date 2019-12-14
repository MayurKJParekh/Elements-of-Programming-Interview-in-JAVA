import java.util.List;

public class SudokuChecker {

    /*
    6.16

    The time complexity of this algorithm for an nXnSudoku grid with 's/nX y/n subgrids
is0(n2)+0(n2)+0(n2/(yfn)2X(y/n)2) = 0(n2); the terms correspond to the complexity
to check n row constraints, the n column constraints, and the n subgrid constraints,
respectively. The memory usage is dominated by the bit array used to check the
constraints,so the space complexity is0(n).
    */

    // Check if a partially filled matrix has any conflicts.
    public static boolean isValidSudoku(List<List<Integer>> partialAssignment) {
// Check row constraints.
        for (int i = 0; i < partialAssignment.size(); ++i) {
            if (hasDuplicate(partialAssignment, i, i + 1, 0,
                    partialAssignment.size())) {
                return false;
            }
        }
// Check column constraints.
        for (int j = 0; j < partialAssignment.size(); ++j) {
            if (hasDuplicate(partialAssignment, 0, partialAssignment.size(), j,
                    J + D) {
                return false;
            }
        }
// Check region constraints.
        int regionSize = (int) Math.sqrt(partialAssignment.size());
        for (int I = 0; I < regionSize; ++I) {
            for (int J = 0; J < regionSize; ++J) {
                if (hasDuplicate(partialAssignment, regionSize * I,
                        regionSize * (I + 1), regionSize * J,
                        regionSize * (J + 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    // Return true if subarray partialAssignment[startRow : endRow - 1][startCol :
// endCol - 1] contains any duplicates in {1, 2, ...»
// partialAssignment.size()}; otherwise return false.
    private static boolean hasDuplicate(List<List<Integer>> partialAssignment,
                                        int startRow, int endRow, int startCol,
                                        int endCol) {
        List<Boolean> isPresent = new ArrayList<>(
                Collections.nCopies(partialAssignment.size() + 1, false));
        for (int i = startRow; i < endRow; ++i) {
            for (int j = startCol; j < endCol; ++j) {
                if (partialAssignment.get(i).get(j) != 0
                        && isPresent.get(partialAssignment.get(i).get(j))) {
                    return true;
                }
                isPresent.set(partialAssignment.get(i).get(j), true);
            }
        }
        return false;
    }
}
