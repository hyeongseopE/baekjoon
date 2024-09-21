import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m,cnt,ans;
    static int [][]map ;
    static int [][]chk;
    static int [][]chk2;
    static int []tx = {-1,1,0,0};
    static int []ty = {0,0,-1,1};

    public static class Node{
        int x,y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void bfs(int x,int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        chk[x][y] = 1;
        while(!q.isEmpty()){
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + tx[i];
                int ny = node.y + ty[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){continue;}
                if(chk[nx][ny] == 0 && map[nx][ny] == 0){
                    q.add(new Node(nx,ny));
                    chk[nx][ny] = 1;
                }else if(map[nx][ny] != 0){
                    map[nx][ny] --;
                    chk[nx][ny] = 1;
                }
            }
        }
    }

    public static void dfs(int x,int y){
        chk2[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + tx[i];
            int ny = y + ty[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m){continue;}
            if(map[nx][ny] !=0 && chk2[nx][ny] == 0 ) {
                dfs(nx, ny);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int [n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while(true) {
            chk = new int[n][m];
            chk2 = new int[n][m];
            ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (chk[i][j] == 0 && map[i][j] == 0) { //빙산 녹이기
                        bfs(i, j);
                    }
                }
            }
            

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] != 0 && chk2[i][j] == 0 ){ // 빙산 2개인지 체크
                        dfs(i,j);
                        ans++;
                    }
                }
            }

            if(ans == 0){
                System.out.println("0");  //빙산이 2개로 분리가 안됐을경우
                break;
            }
            cnt++;
            if(ans >= 2){
                System.out.println(cnt); // 빙산이 2개로 분리됐을경우
                break;
            }
        }

    }
}