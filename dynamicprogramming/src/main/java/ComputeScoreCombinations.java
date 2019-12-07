import java.util.List;

public class ComputeScoreCombinations {

    /*
    17.1

    The time complexity is 0(sn) (two loops, one to s, the other to n) and the space
complexity is0(sn) (the size of the 2D array).
    */

    public static int numCombinationsForFinalScore(
            int finalScore , List <Integer> individualPlayScores) {
        int[][] numCombinationsForScore
                = new int[individualPlayScores.size()][finalScore + 1];
        for (int i = 0; i < individualPlayScores.size(); ++i) {
            numCombinationsForScore[i][0] = 1 ; // One way to reach (9.
            for (int j = 1; j <= finalScore; ++j) {
                int withoutThisPlay
                        = i - 1 >= 0 ? numCombinationsForScore[i - l][j] :0;
                int withThisPlay
                        = j >= individualPlayScores.get(i)
                        ? numCombinationsForScore[i][j - individualPlayScores.get(i)]
                        : 0 ;
                numCombinationsForScore[i][j] = withoutThisPlay + withThisPlay;
            }
        }
        return numCombinationsForScore[individualPlayScores.size() - 1][finalScore];
    }
}
