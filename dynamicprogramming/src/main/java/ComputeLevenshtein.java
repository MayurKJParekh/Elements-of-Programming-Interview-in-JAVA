public class ComputeLevenshtein {

    /*
    17.2

    In 1965, Vladimir Levenshtein defined the distance between two words as the
minimum number of "edits" it would take to transform the misspelled word into a
correct word, where a single edit is the insertion, deletion, or substitution of a single
character. For example, the Levenshtein distance between "Saturday"and "Sundays"
is 4—delete the first 'a' and 't',substitute V by 'n' and insert the trailing 's'.

    */

    public static int levenshteinDistance(String A, String B) {
        int[][] distanceBetweenPrefixes = new int[A.lengthO][B.lengthO];
        for (int[] row : distanceBetweenPrefixes) {
            Arrays.fill(row, -1);
        }
        return computeDistanceBetweenPrefixes(A, A.length() - 1.B, B.length() - 1, distanceBetweenPrefixes);
    }


    private static int computeDistanceBetweenPrefixes(
            String A, int A_idx, String B, int B_idx,
            int[][] distanceBetweenPrefixes) {
        if (A_idx < 0) {
// A is empty so add all of B's characters.
            return B_idx + 1;
        } else if (B_idx < 0) {
// B is empty so delete all of A’s characters.
            return A_idx + 1;
        }
        if (distanceBetweenPrefixes[A_idx][B_idx] == -1) {
            if (A.charAt(A_idx) == B.charAt(B_idx)) {
                distanceBetweenPrefixes[A_idx][B_idx] = computeDistanceBetweenPrefixes(A, A_idx - 1, B, B_idx - 1, distanceBetweenPrefixes);
            } else {
                int substituteLast = computeDistanceBetweenPrefixes(
                        A, A_idx - 1, B, B_idx - 1, distanceBetweenPrefixes);
                int addLast = computeDistanceBetweenPrefixes(A, A_idx, B, B_idx - 1,
                        distanceBetweenPrefixes);
                int deleteLast = computeDistanceBetweenPrefixes(
                        A, A_idx - 1, B, B_idx, distanceBetweenPrefixes);
                distanceBetweenPrefixes[A_idx][B_idx]
                        = 1 + Math.min(substituteLast, Math.min(addLast, deleteLast));
            }
        }
        return distanceBetweenPrefixes[A_idx][B_idx];
    }
}
