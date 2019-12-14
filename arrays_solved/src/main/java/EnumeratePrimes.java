import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnumeratePrimes {

    /*
    6.8

    this
sum asymptotically tends to n log log n, yielding an 0(nlog log n) time bound. The
space complexity is dominated by the storage for P, i.e.,0(n).
    */

    public static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
// isPrime.get(p) represents if p is prime or not. Initially , set each
// to true, excepting ® and 1. Then use sieving to eliminate nonprimes.
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));
        isPrime.set(0, false);
        isPrime.set(1, false);
        for (int p = 2; p <= n; ++p) {
            if (isPrime.get(p)) {
                primes.add(p);
// Sieve p’s multiples.
                for (int j = p; j <= n; j += p) {
                    isPrime.set(j, false);
                }
            }
        }
        return primes;
    }
