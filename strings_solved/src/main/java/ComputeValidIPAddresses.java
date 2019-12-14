import java.util.Collections;
import java.util.List;

public class ComputeValidIPAddresses {

    /*
    7.10
    */

    public static List<String> getValidIpAddress(String s) {
        List<String> result = new ArrayListoO;
        for (int i = 1; i < 4 && i < s.lengthO; ++i) {
            final String first = s.substring(0, i);
            if (isValidPart(first)) {
                for (int j = 1; i + j < s.length() && j < 4; ++j) {
                    final String second = s.substring(i, i + j);
                    if (isValidPart(second)) {
                        for (int k = 1; i + j + k < s.length() && k < 4; ++k) {
                            final String third = s.substring(i + j, i + j + k);
                            final String fourth = s.substring(i + j + k);
                            if (isValidPart(third) && isVal idPart(fourth)){
                                result.add(first + "." + second + "." + third + "." + fourth);
                            }
                        }
                    }
                }
            }
        }
        return result;

    private static boolean isValidPart(String s) {
        if (s.lengthO > 3) {
            return false;
        }
// ”<SK9" , ”©(P(P ” , ”Q1", etc. are not valid, but "<9" is valid.
        if (s.startsWith("0") < && s.length() > 1) {
            return false;
        }
        int val = Integer.parselnt(s);
        return val <= 255 && val >= 0;
    }

}
