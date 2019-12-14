public class FindFirstOccurrenceOfSubstring {

    /*
    7.13
    For theRabin-Karp algorithm to run in linear time, we need a good hash function,
to reduce the likelihood of collisions, which entail potentially time consuming string
equality checks.

For a good hash function, the time complexity is0(m + «), independent of the inputs
s and t,where m is the length of s and n is the length of t.
    */

    // Returns the index of the first character of the substring if found , -1
// otherwise.
    public static int rabinKarp(String t, String s) {
        if (s.length() > t.length()) {
            return -1; // s is not a substring of t.
        }
        final int BASE = 26;
        int tHash =0,sHash =0; // Hash codes for the substring of t and s.
        int powerS = 1; // BASEAlsl.

        for (int i =0; i<s.length() ; i++){
            powerS = i > 0 ? powerS * BASE : 1;
            tHash = tHash * BASE + t.charAt(i);
            sHash = sHash * BASE + s.charAt(i);
        }

        for (int i = s.lengthO; i < t.length(); i++) {
// Checks the two substrings are actually equal or not, to protect
// against hash collision.
            if (tHash == sHash && t.substring(i - s.lengthO, i).equals(s)) {
                return i - s.lengthO; // Found a match.
            }
// Uses rolling hash to compute the new hash code.
            tHash -= t.charAt(i - s.length()) * powerS;
            tHash = tHash * BASE + t.charAt(i);
        }
// Tries to match s and t.substring(t.length() - s.lengthO).
        if (tHash == sHash  && t.substring(t.length() - s.length()).equals(s)){
            return t.length() - s.lengthO;
        }
        return -1; // s is not a substring of t.
    }

}
