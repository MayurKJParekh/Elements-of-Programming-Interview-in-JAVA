public class ComputeBinomialCoefficients {

    /*
    17.4

    The number of subproblems is 0(nk) and once (n“1) and (£“J) are known, (") can be
computed in 0(1) time, yielding an 0(nk) time complexity. The space complexity is
also0(nk); it can easily be reduced to0(k).
    */

    public static int computeBinomialCoefficient(int n, int k) {
        return computeXChooseY(n, k, new int[n + 1][k + 1]);
    }

    private static int computeXChooseY(int x, int y, int[][] xChooseY) {
        if (y == 0 || x == y) {
            return 1;
        }
        if (xChooseY[x][y] == 0) {
            int withoutY = computeXChooseY(x - 1, y, xChooseY);
            int withY = computeXChooseY(x - 1, y - 1, xChooseY);
            xChooseY[x][y] = withoutY + withY;
        }
        return xChooseY[x][y];
    }
}
