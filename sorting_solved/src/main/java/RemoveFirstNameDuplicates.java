import java.util.List;

public class RemoveFirstNameDuplicates {

    /*
    14.3

    The time complexity is0(n log n) and the space complexity is0(1).
    */

    public static class Name implements Comparable<Name> {
        String firstName;
        String lastName;

        public int compareTo(Name name) {
            int cmpFirst = firstName.compareTo(name.firstName);
            if (cmpFirst != 0) {
                return cmpFirst;

            }
            return lastName.compareTo(name.lastName);
        }
    }

    public static void eliminateDuplicate(List<Name> A) {
        Collections.sort(A); // Makes identical elements become neighbors.
        int result = 0;
        for (int first = 1; first < A.size(); first++) {
            if (!A.get(first).firstName.equals(A.get(result).firstName)) {
                A.set(++result, A.get(first));
            }
        }
// Shrinks array size.
        A.subList(++result, A.size()).clear();
    }
}
