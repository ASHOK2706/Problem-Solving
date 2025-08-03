import java.util.Arrays;
import java.util.Scanner;

public class _13_NinjaAndHisFriends {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] grid = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                grid[i][j] = in.nextInt();
            }
        }
//        int[][][] dp = new int[n][m][m];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                Arrays.fill(dp[i][j], -1);
//            }
//        }
//        System.out.println(getMaximum(0, 0, m-1, grid, dp));
        System.out.println(getMaximum(n, m, grid));
    }
/*
    // Memoization
    private static int getMaximum(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length) {
            return -1000000000;
        }
        if (i == grid.length-1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int maxi = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2) {
                    value += grid[i][j1];
                } else {
                    value += grid[i][j1] + grid[i][j2];
                }
                value += getMaximum(i + 1, j1 + dj1, j2 + dj2, grid, dp);
                maxi = max(maxi, value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
*/

/*
    //Tabulation
    private static int getMaximum(int n, int m, int[][] grid) {
        int[][][] dp = new int[n][m][m];
        for (int j1=0; j1<m; j1++) {
            for (int j2=0; j2<m; j2++) {
                if (j1 == j2) dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        for (int i = n-2; i>=0; i--) {
            for (int j1 = 0; j1<m; j1++) {
                for (int j2 = 0; j2<m; j2++) {
                    int maxi = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int value = 0;
                            if (j1 == j2) {
                                value += grid[i][j1];
                            } else {
                                value += grid[i][j1] + grid[i][j2];
                            }
                            if (j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) {
                                value += dp[i + 1][j1 + dj1][j2 + dj2];
                            } else {
                                value += -1000000000;
                            }

                            maxi = max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m-1];
    }
*/


    private static int getMaximum(int n, int m, int[][] grid) {
        int[][] front = new int[m][m];
        for (int j1=0; j1<m; j1++) {
            for (int j2=0; j2<m; j2++) {
                if (j1 == j2) front[j1][j2] = grid[n-1][j1];
                else front[j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        for (int i = n-2; i>=0; i--) {
            int[][] curr = new int[m][m];
            for (int j1 = 0; j1<m; j1++) {
                for (int j2 = 0; j2<m; j2++) {
                    int maxi = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int value = 0;
                            if (j1 == j2) {
                                value += grid[i][j1];
                            } else {
                                value += grid[i][j1] + grid[i][j2];
                            }
                            if (j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) {
                                value += front[j1 + dj1][j2 + dj2];
                            } else {
                                value += -1000000000;
                            }

                            maxi = max(maxi, value);
                        }
                    }
                    curr[j1][j2] = maxi;
                }
            }
            front = curr;
        }
        return front[0][m-1];
    }


    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}