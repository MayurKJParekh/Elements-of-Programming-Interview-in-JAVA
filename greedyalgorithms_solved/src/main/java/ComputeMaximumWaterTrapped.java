import java.util.List;

public class ComputeMaximumWaterTrapped {

    /*
    18.7

    (a) A graphical depiction of the array (1,2,1,3, 4, 4,5,6,2,1,3,1, 3,2,1,2,4,1).
    The shaded area between 4 and 16 is the maximum water that can be trapped by the array in (a)


    For the given example, we begin with (0,17), which has a capacity of 1 X 17 = 17.
Since the left and right lines have the same height, namely1, we can advance both,so
now we consider (1,16). The capacity is 2 X 15 = 30. Since 2 < 4, we move to (2,16).
The capacity is1X 14 = 14. Since1 < 4, we move to (3,16). The capacity is3 X 13 = 39.
Since 3 < 4, we move to (4,16). The capacity is 4 X 12 = 48. Future iterations, which
we do not show, do notsurpass 48, which is the result.


We iteratively eliminate one line or two lines at a time, and we spend 0(1) time per
iteration,so the time complexity is0(n).
    */

    public static int getMaxTrappedWater(List<Integer> heights) {
        int i = 0, j = heights.size() - 1, maxWater = 0;
        while (i < j) {
            int width = j - i ;
            maxWater = Math.max(maxWater ,
                    width * Math.min(heights.get(i), heights.get(j)));
            if (heights.get(i) > heights.get(j)){
                --j;
            } else if (heights.get(i) < heights.get(j)){
                ++i ;
            } else { // heights.get(i) == heights.get(j).
                ++i ;
                --j;
            }
        }
        return maxWater;
    }
}
