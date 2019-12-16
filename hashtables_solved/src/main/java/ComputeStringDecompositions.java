import java.util.Collections;
import java.util.List;

public class ComputeStringDecompositions {

    /*
    13.12
    This problem is concerned with taking a string (the "sentence" string) and a set
of strings (the "words"), and finding the substrings of the sentence which are the
concatenation of all the words (in any order). For example, if the sentence string
is "amanaplanacanal" and the set of words is {"can","apl","ana"), "aplanacan" is a
substring of the sentence that is the concatenation of all words.

Let's begin by considering the problem of checking whether a string is the
concatenation strings in words. We can solve this problem recursively—we find a
string from words that is a prefix of the given string, and recurse with the remaining
words and the remaining suffix.
When allstringsin wordshave equallength,say n,only one distinctstringin words
can be a prefix of the given string. So we can directly check the first n characters of
the string to see if they are in words. If not, the string cannot be the concatenation of
words. If it is, we remove thatstring from words and continue with the remainder of
the string and the remaining words.
To find substrings in the sentence string that are the concatenation of the strings
in words, we can use the above processfor each index in the sentence as the starting
index.

We analyze the time complexity asfollows. Let m be the number of words and n the
length of each word. Let N be the length of the sentence. For any fixed i, to check if
the string of length nm starting at an offset of i in the sentence is the concatenation
of all words has time complexity 0(nm), assuming a hash table is used to store the
set of words. This implies the overall time complexity is 0(Nnm). In practice, the
individual checks are likely to be much faster because we can stop as soon as a
mismatch is detected.
    */

    public static List<Integer> findAHSubstrings(String s, List<String> words) {
        Map<String, Integer> wordToFreq = new HashMap<>();
        for (String word : words) {
            increment(word, wordToFreq);
        }
        int unitSize = words.get(0).length();
        Listdnteger > result = new ArrayList<>();
        for (int i = 0; i + unitSize * words.size() <= s.length(); ++i) {
            if (matchAHWordsInDict(s, wordToFreq, i, words.size(), unitSize)) {
                result.add(i);
            }
        }
        return result;

    private static boolean matchAHWordsInDict(String s,
                                              Map<String, Integer> wordToFreq,
                                              int start, int numWords,
                                              int unitSize) {
        Map<String, Integer> currStringToFreq = new HashMap<>();
        for (int i = 0; i < numWords; ++i) {
            String currWord
                    = s.substring(start + i * unitSize, start + (i + 1) * unitSize);
            Integer freq = wordToFreq.get(currWord);
            if (freq == null) {
                return false;
            }
            increment(currWord, currStringToFreq);
            if (currStringToFreq.get(currWord) > freq) {
// currWord occurs too many times for a match to be possible.
                return false;
            }
        }
        return true;
    }

    private static void increment(String word, Map<String, Integer> diet) {
        Integer count = diet.get(word);
        if (count == null) {
            count = 0;
        }
        count++;
        diet.put(word, count);
    }
}
