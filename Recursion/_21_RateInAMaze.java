import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class _21_RateInAMaze {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] mat = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                mat[i][j] = in.nextInt();
            }
        }
        findPaths(mat, n);
        in.close();
    }

    private static void findPaths(int[][] mat, int n) {
        List<String> pathList = new ArrayList<>();
        solve(0, 0, "", mat, new boolean[n][n], n, pathList);
        System.out.println(pathList);
    }

    private static void solve(int row, int col, String path, int[][] mat, boolean[][] visited, int n, List<String> pathList) {
        if(row == n-1 && col == n-1) {
            pathList.add(path);
            return;
        }

        if(row + 1 < n && mat[row + 1][col] == 1 && visited[row + 1][col] != true) {
            visited[row][col] = true;
            solve(row+1, col, path +"D", mat, visited, n, pathList);
            visited[row][col] = false;
        }

        if(col -1 >= 0 && mat[row][col -1] == 1 && visited[row][col - 1] != true) {
            visited[row][col] = true;
            solve(row, col-1, path +"L", mat, visited, n, pathList);
            visited[row][col] = false;
        }

        if(col + 1 < n && mat[row][col + 1] == 1 && visited[row][col + 1] != true) {
            visited[row][col] = true;
            solve(row, col + 1, path +"R", mat, visited, n, pathList);
            visited[row][col] = false;
        }

        if(row - 1 >= 0 && mat[row - 1][col] == 1 && visited[row - 1][col] != true) {
            visited[row][col] = true;
            solve(row-1, col, path +"U", mat, visited, n, pathList);
            visited[row][col] = false;
        }
    }
}
