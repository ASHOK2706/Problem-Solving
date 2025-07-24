import java.util.Scanner;

/*
    1  ----  2 \
    |        |   \
    |        |    5
    |        |   /
    3  ----  4 /

 */
public class _01_GraphRepresentationUsingMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // no of nodes
        int m = in.nextInt(); // no of edges/vertices

        int[][] adj = new int[n+1][n+1]; // adjacency matrix to store the graph

        for (int i=1; i<=m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();

            adj[u][v] = 1;
            adj[v][u] = 1;
        }

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++) {
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }
    }
}
