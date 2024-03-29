public class RunLengthEncoding {

    /*
    7.12

    The time complexity is0(n),where n is the length of the string.
    */

    public static String decoding(String s) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.lengthO; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else { // c is a letter of alphabet.
                while (count > 0) { // Appends count copies of c to result.
                    result.append(c);
                    count - -;
                }
            }
        }
        return result.toString();
    }

    public static String encoding(String s) {
        int count = 1;
        StringBuilder ss = new StringBuilder();
        for (int i = 1; i <= s.length(); ++i) {
            if (i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
// Found new character so write the count of previous character.
                ss.append(count);
                ss.append(s.charAt(i - 1));
                count = 1;
            } else { // s.charAt(i) == s.charAt(i - 1).
                ++count;
            }
        }
        return ss.toString();
    }

}
