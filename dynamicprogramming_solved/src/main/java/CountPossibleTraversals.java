public class CountPossibleTraversals {

    /*
    17.3

1 1 1  1  1
1 2 3  4  5
1 3 6  10 15
1 4 10 20 35
1 5 15 35 70
0 row - col is 1 way
1 to width -1 = arr[row][col] = arr[row][col-1]+arr[row-1][col]

total way arr[m][n]

O(m*n)
    */

    public static int numberOfWays(int n, int m) {
        return computeNumberOfWaysToXY(n - 1, m - 1, new int[n][m]) ;
    }

    private static int computeNumberOfWaysToXY(int x, int y,
                                               int[][] numberOfWays) {
        if (x == 0 || y == 0) {
            return 1;
        }
        if (numberOfWays[x][y] ==0){
            int waysTop = x == 0 ? 0 : computeNumberOfWaysToXY(x - 1, y, numberOfWays);
            int waysLeft = x == 0 ? 0 :computeNumberOfWaysToXY(x, y - 1, numberOfWays);
            numberOfWays[x][y] = waysTop + waysLeft;
        }
        return numberOfWays[x][y];
    }
}
