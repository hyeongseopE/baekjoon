import java.io.*;
import java.util.*;

public class Main {
    static int map[][] = new int [101][101];
    static boolean vitsit[][];
    static int [] tx = {-1,1,0,0};
    static int [] ty = {0,0,-1,1};
    static int n ;


    static public class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    static public void bfs(int x,int y,int m){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        vitsit[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + tx[i];
                int ny = node.y + ty[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n){continue;}
                if(map[nx][ny] <= m && !vitsit[nx][ny]){
                    q.add(new Node(nx,ny));
                    vitsit[nx][ny] = true;
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= 100; i++) {
            vitsit = new boolean[101][101];
            cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] <= i && !vitsit[j][k]) {
                        bfs(j, k, i);
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!vitsit[j][k]){
                        bfs(j,k,101);
                        cnt++;
                    }
                }
            }
            list.add(cnt);
        }


        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list.get(0));

    }
}