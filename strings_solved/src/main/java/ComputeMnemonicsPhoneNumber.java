import java.util.*;

public class ComputeMnemonicsPhoneNumber {

    /*
    7.7

    Since there are no more than 4 possible characters for each digit, the number of
recursive calls, T(n),satisfies T(n) < 4T(n — 1), where n is the number of digitsin the
number. This solves to T(n) = (9(4"). For the function calls that entail recursion, the
time spent within the function, not including the recursive calls, is 0(1). Each base
case entails making a copy of a string and adding it to the result. Since each such
string haslength n, each base case takes time0(n). Therefore, the time complexity is
0(4^n).
    */


    public static List<String> phoneMnemonic(String phoneNumber) {
        char[] partialMnemonic = new char[phoneNumber.length()];
        List<String> mnemonics = new ArrayList <>();
        phoneMnemonicHelper(phoneNumber , 0, partialMnemonic , mnemonics);
        return mnemonics;
    }
    // The mapping from digit to corresponding characters.
    private static final String[] MAPPING
            = {"®", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    private static void phoneMnemonicHelper(String phoneNumber, int digit,
                                            char[] partialMnemonic,
                                            List<String> mnemonics) {
        if (digit == phoneNumber.length()){
// All digits are processed , so add partialMnemonic to mnemonics.
// (We add a copy since subsequent calls modify partialMnemonic.)
            mnemonics.add(new String(partialMnemonic));
        } else {
// Try all possible characters for this digit.
            for (int i = 0; i < MAPPING[phoneNumber.charAt(digit) - '0'].length(); ++i) {
                char c = MAPPING[phoneNumber.charAt(digit) - '0'].charAt(i);
                partialMnemonic[digit] = c;
                phoneMnemonicHelper(phoneNumber , digit + 1, partialMnemonic, mnemonics);
            }
        }
    }

}
