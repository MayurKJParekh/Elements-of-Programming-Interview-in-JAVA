import java.util.List;

public class PrettyPrintingProblem {

    /*
    17.11

    Let L be the line length. Then there can certainly be no more than L words on a line,
so the amount of time spent processing each word is 0(L). Therefore, if there are n
words, the time complexity is 0(nL). The space complexity is0(n) for the cache.
    */

    public static int minimumMessiness(List<String> words, int lineLength) {
// minimumMessiness[i] is the minimum messiness when placing words[Q : iJ.
        int[] minimumMessiness = new int[words.size()];
        Arrays.fill(minimumMessiness, Integer.MAX_VALUE);
        int numRemainingBlanks = lineLength - words.get(0).length();
        minimumMessiness[0] = numRemainingBlanks * numRemainingBlanks;
        for (int i = 1; i < words.size(); ++i) {
            numRemainingBlanks = lineLength - words.get(i).length();
            minimumMessiness[i] = minimumMessiness[i - 1] + numRemainingBlanks * numRemainingBlanks;
// Try adding words.get(i - 1), words.get(i - 2), ...
            for (int j = i - 1; j >= 0;--j) {
                numRemainingBlanks -= (words.get(j).length() + 1);
                if (numRemainingBlanks < 0) {
// Not enough space to add more words.
                    break;
                }
                int firstJMessiness = j - 1 < 0 ? 0 : minimumMessiness[j - 1];
                int currentLineMessiness = numRemainingBlanks * numRemainingBlanks;
                minimumMessiness[i] = Math.min(minimumMessiness[i],
                        firstJMessiness + currentLineMessiness);
            }
        }
        return minimumMessiness[words.size() - 1];
    }
}