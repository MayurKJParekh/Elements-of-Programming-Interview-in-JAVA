import java.util.HashMap;
import java.util.Map;

public class IsLetterConstructable {

    /*
    13.2
    In the worst-case, the letter is not constructible or the last character of the magazine is
essentially required. Therefore, the time complexity is0(m+n) where m and n are the
number of characters in the letter and magazine, respectively. The space complexity
is the size of the hash table constructed in the pass over the letter, i.e., 0(L), where L
is the number of distinct characters appearing in the letter
    */

    public static boolean isLetterConstructibleFromMagazine(String letterText,
                                                            String magazineText) {
        Map<Character, Integer> charFrequencyForLetter = new HashMap<>();
// Compute the frequencies for all chars in letterText.
        for (int i = 0; i < letterText.length(); i++) {
            char c = letterText.charAt(i);
            if (!charFrequencyForLetter.containsKey(c)) {
                charFrequencyForLetter.put(c, 1);
            } else {
                charFrequencyForLetter.put(c, charFrequencyForLetter.get(c) + 1);
            }
        }
// Check if the characters in magazineText can cover characters in
// letterText.
        for (char c : magazineText.toCharArray()) {
            if (charFrequencyForLetter.containsKey(c)) {
                charFrequencyForLe tter.put(c, charFrequencyForLe tter.get(c) - 1);
                if (charFrequencyForLetter.get(c) == 0) {
                    charFrequencyForLetter.remove(c);
// All characters for letterText are matched.
                    if (charFrequencyForLetter.isEmpty()) {
                        break;
                    }
                }
            }
        }
// Empty charFrequencyForLetter means every char in letterText can be
// covered by a character in magazineText.
        return charFrequencyForLetter.isEmpty();
    }
}
