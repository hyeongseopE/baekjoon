import java.io.*;
import java.util.*;

public class Main {
    static int [][]map = new int [101][101];
    static int [][]vitsit;
    static int []last = new int [200];
    static int [] tx = {-1,1,0,0};
    static int [] ty = {0,0,-1,1};
    static int n,m,ans,cnt;


    static public class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    static public void bfs(int x,int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        vitsit[x][y] = 1;

        while(!q.isEmpty()){
            Node node = q.poll();


            for (int i = 0; i < 4; i++) {
                int nx = node.x + tx[i];
                int ny = node.y + ty[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){continue;}
                if(map[nx][ny] == 0 && vitsit[nx][ny] == 0){
                    q.add(new Node(nx,ny));
                    vitsit[nx][ny] = 1;
                }
                if(map[nx][ny] == 1 && vitsit[nx][ny] == 0){
                    vitsit[nx][ny] = 2;
                    last[cnt] ++;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            vitsit = new int[101][101];
            ans = 0;
            bfs(0,0);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(vitsit[i][j] == 2){
                        map[i][j] = 0;
                        ans = 1;
                    }
                }
            }
            if(ans == 0){
                break;
            }
            cnt++;
        }

        System.out.println(cnt+" "+last[cnt-1]);


    }
}