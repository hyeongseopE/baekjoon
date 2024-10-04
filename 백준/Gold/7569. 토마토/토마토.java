import java.io.*;
import java.util.*;

public class Main {
    static int[][][] map = new int[101][101][101];
    static int[][][] vitsit = new int[101][101][101];
    static int n, m, cnt,h;

    static int tx[] = new int[]{-1, 1, 0, 0,0,0};
    static int ty[] = new int[]{0, 0, -1, 1,0,0};
    static int td[] = new int[]{0, 0, 0,0,-1,1};
    static Queue<Node> q = new LinkedList<>();

    public static class Node {
        int x, y,d;

        public Node(int x, int y,int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = node.x + tx[i];
                int ny = node.y + ty[i];
                int nd = node.d + td[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nd < 0 || nd >= h ) {
                    continue;
                }
                if (map[nd][nx][ny] == 0 && vitsit[nd][nx][ny] == 0) {
                    vitsit[nd][nx][ny] = vitsit[node.d][node.x][node.y] + 1;
                    cnt = vitsit[node.d][node.x][node.y] + 1;
                    q.add(new Node(nx, ny, nd));
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
        h = Integer.parseInt(st.nextToken());

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1){
                        q.add(new Node(j,k,i));
                    }
                }
            }
        }
        bfs();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(map[i][j][k] == 0 && vitsit[i][j][k] == 0){
                        System.out.println("-1");
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(cnt);



    }
}