import java.util.Iterator;

public class ComputeAverageTopThree {

    /*
    13.11
    For example,suppose the first three scoresseen for Adamare 97, 91, and 96, in that
order. The min-heap for Adam contains 97 after the first of hisscores is read, 91,97
after the second of hisscoresisread, and 91,96,97 after the third of hisscoresisread.
Suppose the next score for Adam in the file is 88. Since 88 isless than 91 we do not
update his top three scores. Then if the next score for Adam is 97, which is greater
than 91, we remove the 91 and add 97, updating his top three scores to 96,97,97.


    */

    public static String findStudentWithHighestBestOfThreeScores(
            Iterator<Object>nameScoreData) {

        Map<String, PriorityQueue<Integer>> studentScores = new HashMap<>();

        while (nameScoreData.hasNext()) {
            String name = (String) nameScoreData.next();
            Integer score = (Integer) nameScoreData.next();
            PriorityQueue<Integer> scores = studentScores.get(name);
            if (scores == null) {
                scores = new PriorityQueue<>();
                studentScores.put(name, scores);
            }
            scores.add(score);
            if (scores.size() > 3) {
                scores.poll(); // Only keep the top 3 scores.
            }
        }

        String topStudent = "no such student";
        int currentTopThreeScoresSum = 0;

        for (Map.Entry<String, PriorityQueue<Integer>> scores :
                studentScores.entrySet()) {
            if (scores.getValue().size() == 3) {
                int currentScoresSum = getTopThreeScoresSum(scores.getValue());
                if (currentScoresSum > currentTopThreeScoresSum) {
                    currentTopThreeScoresSum = currentScoresSum;
                    topStudent = scores.getKey();
                }
            }
        }

        return topStudent;
    }

    // Returns the sum of top three scores.
    private static int getTopThreeScoresSum(PriorityQueue<Integer> scores) {
        Iterator<Integer> it = scores.iterator();
        int result = 0;
        while (it.hasNext()) {
            result += it.next();
        }
        return result;
    }

}
