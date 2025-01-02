import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int [][]map;
    static int [][]visit ;
    static int []tx = {-1,1,0,0};
    static int []ty = {0,0,-1,1};
    static int n,m;

    static int bfs(int x, int y,int army){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visit[x][y] = 1;
        int cnt=1;
        while(!q.isEmpty()){
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x+tx[i];
                int ny = node.y+ty[i];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n ){continue;}
                if(visit[nx][ny] == 0 && map[nx][ny] == army){
                    cnt++;
                    visit[nx][ny]=1;
                    q.add(new Node(nx,ny));
                }
            }
        }
        return cnt;
    }

    static class Node {
        int x,y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int [m][n];
        visit = new int [m][n];
        int []ans = new int [2];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if(s.charAt(j) == 'W'){
                    map[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visit[i][j] == 0){
                   int t = bfs(i,j,map[i][j]);
                   ans[map[i][j]] += t * t;
                }
            }
        }
        System.out.println(ans[1]+" "+ans[0]);

    }
}
