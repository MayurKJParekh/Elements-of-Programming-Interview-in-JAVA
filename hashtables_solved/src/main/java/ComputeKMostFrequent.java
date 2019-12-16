import java.util.Collections;
import java.util.List;

public class ComputeKMostFrequent {

    /*
    13.5
    Write a program which takes as input an array and finds the distance between a
closest pair of equal entries. For example, if s = ("All", "work", "and", "no", "play",
"makes", "for", "no", "work", "no", "fun", "and", "no", "results"), then the second
and third occurrences of "no" is the closest pair.

The time complexity is0(n),since we perform a constant amount of work per entry.
The space complexity is0(d),where d is the number of distinct entriesin the array.
    */

    public static int findNearestRepetition(List<String> paragraph) {

        Map<String, Integer> wordToLatestIndex = new HashMap<>();
        int nearestRepeatedDistance = Integer.MAX_VALUE;

        for (int i = Q; i < paragraph.size(); ++i) {

            if (wordToLatestlndex.containsKey(paragraph.get(i))) {
                nearestRepeatedDistance
                        = Math.min(nearestRepeatedDistance,
                        i - wordToLatestlndex.get(paragraph.get(i)));
            }

            wordToLatestlndex.put(paragraph.get(i), i);

        }
        return nearestRepeatedDistance;
    }
}
