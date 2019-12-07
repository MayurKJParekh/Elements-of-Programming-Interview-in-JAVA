import java.util.List;

public class GasUpProblem {

    /*
    18.6
In particular, consider a city where the amount of gasin the tank is minimum when
we enter that city. Observe that it does not depend where we begin from—because
graphs are the same up to translation and shifting, a city that is minimum for one
graph will be a minimum city for all graphs. Let z be a city where the amount of gas
in the tank before we refuel at that city is minimum. Now suppose we pick z as the
starting point, with the gas present at z. Since we never have less gas than we started
with at z, and when we return to z we have 0 gas(since it's given that the total amount
of gas is just enough to complete the traversal) it means we can complete the journey
without running out of gas. Note that the reasoning given above demonstrates that
there always exists an ample city.


    The time complexity is0(n), and the space complexity is(9(1).
    */

    private static class CityAndRemainingGas {
        public Integer city;
        public Integer remainingGallons;

        public CityAndRemainingGas(Integer city, Integer remainingGallons) {
            this.city = city;
            this.remainingGallons = remainingGallons;
        }
    }

    private static final int MPG = 20;
    // gallons[ij is the amount of gas in city i, and distances[i] is the distance
    // city i to the next city.
    public static int f

    indAmpleCi ty(List<Integer> gallons,
                  List<Integer> distances) {
        int remainingGallons = 0;
        CityAndRemainingGas min = new Ci tyAndRemainingGas(0, 0);
        final int numCities = gallons.size();
        for (int i = 1; i < numCities; ++i) {
            remainingGallons += gallons.get(i - 1) - distances.get(i - 1) / MPG;
            if (remainingGallons < min.remainingGallons) {
                min = new CityAndRemainingGas(i, remainingGallons);
            }
        }
        return min.city;
    }
}
