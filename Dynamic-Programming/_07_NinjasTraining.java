import java.util.Arrays;
import java.util.Scanner;

public class _07_NinjasTraining {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int[][] points = new int[n][3];
        for (int i=0; i<n; i++) {
            for (int j=0; j<3; j++) {
                points[i][j] = in.nextInt();
            }
        }


/*
        int[][] dp = new int[n][4];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(getMaxPoints(n-1, 3, points, dp));
*/

        System.out.println(getMaxPoints(n, points));
    }

    //Memoizatio
/*
    private static int getMaxPoints(int day, int last, int[][] points, int[][] dp) {
        if (day == 0) {
            int maxi = 0;
            for (int task = 0; task<3; task++) {
                if (task != last) {
                    maxi = max(maxi, points[day][task]);
                }
            }
            return maxi;
        }
        if (dp[day][last] != -1) return dp[day][last];

        int maxi = 0;

        for (int task = 0; task<3; task++) {
            if (task != last) {
                int point = points[day][task] + getMaxPoints(day-1, task, points, dp);
                maxi = max(maxi, point);
            }
        }
        return dp[day][last] = maxi;

    }
*/
    //Tabulation
/*
    private static int getMaxPoints(int n, int[][] points) {
        int[][] dp = new int[n][4];
        dp[0][0] = max(points[0][1], points[0][2]);
        dp[0][1] = max(points[0][0], points[0][2]);
        dp[0][2] = max(points[0][0], points[0][1]);
        dp[0][3] = max(points[0][0], max(points[0][1], points[0][2]));
        for (int day=1; day<n; day++) {
            for (int last = 0; last<4; last++) {
                int maxi = 0;
                for (int task = 0; task<3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day-1][task];
                        maxi = max(maxi, point);
                    }
                }
                dp[day][last] = maxi;
            }
        }
        return dp[n-1][3];
    }
*/
    //Space Optimization
    private static int getMaxPoints(int n, int[][] points) {
        int[] prev = new int[4];
        int[] curr = new int[4];
        prev[0] = max(points[0][1], points[0][2]);
        prev[1] = max(points[0][0], points[0][2]);
        prev[2] = max(points[0][0], points[0][1]);
        prev[3] = max(points[0][0], max(points[0][1], points[0][2]));
        for (int day=1; day<n; day++) {
            for (int last = 0; last<4; last++) {
                int maxi = 0;
                for (int task = 0; task<3; task++) {
                    if (task != last) {
                        int point = points[day][task] + prev[task];
                        maxi = max(maxi, point);
                    }
                }
                curr[last] = maxi;
            }
            prev = curr;
            curr = new int[4];
        }
        return prev[3];
    }




    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
