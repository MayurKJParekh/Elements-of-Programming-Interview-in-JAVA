public class CountMovesToClimbStairs {

    /*
    17.10

    Write a program which takes as inputs n and k and returns the number of ways in
which you can get to your destination. For example, if n = 4 and k = 2, there are five
waysin which to get to the destination:
• four single stair advances,
• two single stair advancesfollowed by a double stair advance,
•
a single stair advance followed by a double stair advance followed by a single
stair advance,
•
a double stair advance followed by two single stairs advances, and
• two double stair advances.

We take 0(k) time to fill in each entry, so the total time complexity is0(kn). The space
complexity is0(n).
    */

    public static int numberOfWaysToTop(int top, int maximumStep) {
        return computeNumberOfWaysToH(top, maximumStep, new int[top + 1]);
    }

    private static int computeNumberOfWaysToH(int n, int maximumStep,
                                              int[] numberOfWaysToH) {
        if (n <= 1) {
            return 1;
        }
        if (numberOfWaysToH[n] == 0) {
            for (int i = 1; i <= maximumStep && n - i >= 0; ++i) {
                numberOfWaysToH[n]
                        += computeNumberOfWaysToH(n - i, maximumStep, numberOfWaysToH);
            }
        }
        return numberOfWaysToH[n];
    }
}
