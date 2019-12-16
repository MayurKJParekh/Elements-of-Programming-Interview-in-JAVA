public class CollatzConjecture {

    /*
    13.13
    We cannot say much about time complexity beyond the obvious, namely that it is at
least proportional to n.

    */

    public static boolean testCollatzConjecture(int n) {
// Stores odd numbers already tested to converge to 1.
        Set<Long> verifiedNumbers = new HashSet<>();
// Starts from 3, since hypothesis holds trivially for 1 and 2.
        for (int i = 3; i <= n; i += 2) {
            Set<Long> sequence = new HashSet<>();
            long testl = i;
            while (testl >= i) {
                if (!sequence.add(testl)) {
// We previously encountered testl, so the Collatz sequence
// has fallen into a loop. This disproves the hypothesis , so
// we short-circuit, returning false.
                    return false;
                }
                if ((testl % 2) != 0) { // Odd number
                    if (!verifiedNumbers.add(testl)) {
                        break; // testl has already been verified to converge to 1.
                    }
                    long nextTestl = 3 * testl + 1; // Multiply by 3 and add 1.
                    if (nextTestl <= testl) {
                        throw new ArithmeticException("Collatz sequence overflow for " + i);
                    }
                    testl = nextTestl;
                } else {
                    testl /= 2; // Even number, halve it.
                }
            }
        }
        return true;
    }
}
