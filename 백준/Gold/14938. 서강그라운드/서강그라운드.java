import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[] post;
    static int[][] dist;
    static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        post = new int[n + 1];
        dist = new int[n + 1][n + 1];


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }


        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            dist[x1][x2] = Math.min(dist[x1][x2], weight);
            dist[x2][x1] = Math.min(dist[x2][x1], weight);
        }


        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }


        int maxItem = 0;
        for (int i = 1; i <= n; i++) {
            int collectedItems = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] <= m) {
                    collectedItems += post[j];
                }
            }
            maxItem = Math.max(maxItem, collectedItems);
        }


        System.out.println(maxItem);
    }
}
