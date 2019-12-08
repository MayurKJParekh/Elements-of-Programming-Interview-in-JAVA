import java.util.List;

public class MaximumCoinsGain {

    /*
    17.9

There are 0(n2) possible arguments for R(a,b), where n is the number of coins, and
the time spent to compute R from previously computed valuesis0(1). Hence, R can
be computed in 0(n2) time.
    */

    public static int pickUpCoins(List<Integer> coins) {
        return computeMaximumRevenueForRange(coins, 0, coins.size() - 1,
                new int[coins.size()][coins.sizeQ]);
    }

    private static int computeMaximumRevenueForRange(
            List<Integer> coins, int a, int b, int[][] maximumRevenueForRange) {
        if (a > b) {
// No coins left.
            return 0;

        if (maximumRevenueForRange[a][b] == 0) {
                int maximumRevenueA
                        = coins.get(a)
                        + Math.min(computeMaximumRevenueForRange(coins, a + 2, b,
                        maximumRevenueForRange),
                        computeMaximumRevenueForRange(coins, a + 1, b - 1,
                                maximumRevenueForRange));
                int maximumRevenueB
                        = coins.get(b)
                        + Math.min(computeMaximumRevenueForRange(coins, a + 1, b - 1,
                        maximumRevenueForRange),
                        computeMaximumRevenueForRange(coins, a, b - 2,
                                maximumRevenueForRange));
                maximumRevenueForRange[a][b] = Math.max(maximumRevenueA, maximumRevenueB);
            }
            return maximumRevenueForRange[a][b];
        }
    }
