import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[1001][1001];
    static int[][] vitsit = new int[1001][1001];
    static int n, m, ans, cnt, cntchk;
    static int min_Value = Integer.MAX_VALUE;
    static int tx[] = new int[]{-1, 1, 0, 0};
    static int ty[] = new int[]{0, 0, -1, 1};
    static Queue<Node> q = new LinkedList<>();

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + tx[i];
                int ny = node.y + ty[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == 0 && vitsit[nx][ny] == 0) {
                    vitsit[nx][ny] = vitsit[node.x][node.y] + 1;
                    cnt = vitsit[node.x][node.y] + 1;
                    q.add(new Node(nx, ny));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.add(new Node(i,j));
                }
            }
        }

        bfs();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0 && vitsit[i][j] == 0){
                    System.out.println("-1");
                    System.exit(0);
                }
            }
        }
        System.out.println(cnt);



    }
}