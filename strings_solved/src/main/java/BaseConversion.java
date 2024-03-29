import java.util.HashMap;
import java.util.Map;

public class BaseConversion {

    /*
    7.2
    */

    private static Map<Integer, Character> numToCon = new HashMap<>();
    private static Map<Character, Integer> conToNum = new HashMap<>();
    private static int[] bases = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private static char[] conversions = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String baseConversion(String s, int b1, int b2) {
        for (int i = 0; i <= 15; i++) {
            numToCon.put(bases[i], conversions[i]);
            conToNum.put(conversions[i], bases[i]);
        }
        int decimalConversion = 0;
        int power = 0;
        int endIdx = (s.length() > 0 && !Character.isDigit(s.charAt(0))) ? 1 : 0;
        for (int i = s.length() - 1; i >= endIdx; i--) {
            decimalConversion += ((int) (Math.pow(b1, power++))) * conToNum.get(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (decimalConversion > 0) {
            int rem = decimalConversion % b2;
            decimalConversion /= b2;
            sb.append(numToCon.get(rem));
        }
        return (endIdx != 0 && sb.length() > 0 ? s.substring(0, 1) : "") + sb.reverse().toString();
    }

    private static String constructFromBase(int numAsInt, int base) {
        return numAsInt == 0
                ? ""
                :constructFromBase(numAsInt / base, base)
                 + (char) (numAsInt % base >= 10 ? 'A' + numAsInt % base - 10
                        : '0' + numAsInt % base);
    }

    public static String convertBase(String numAsString , int bl, int b2) {
        boolean isNegative = numAsString.startsWith("-");
        int numAsInt = 0;
        for (int i = (isNegative ? 1 : 0); i < numAsString.length(); ++i) {
            numAsInt *= bl ;
            numAsInt += Character.isDigit(numAsString.charAt(i))
                    ? numAsString .charAt(i) - '0' : numAsString .charAt(i) - 'A' + 10;
        }
        return (isNegative ? : "")
        + (numAsInt == 0 ? "0" : constructFromBase(numAsInt , b2));
    }
}
