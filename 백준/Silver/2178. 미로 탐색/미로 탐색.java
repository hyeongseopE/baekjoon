import java.io.*;
import java.util.*;

public class Main {
    static int arr [][] = new int [101][101];


    static int n ;
    static int m;
    static int tx [] = {-1,1,0,0};
    static int ty [] = {0,0,-1,1};
    static boolean chk [][] = new boolean[101][101];


    static public class Node{
        int x;
        int y;
        int cnt;
        public Node(int x,int y,int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

    }
    static int bfs (int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,1));
        chk[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            if(node.x == n-1 && node.y == m-1){
                return node.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + tx[i];
                int ny = node.y + ty[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){continue;}
                if(!chk[nx][ny] && arr[nx][ny] == 1){
                    chk[nx][ny] = true;
                    q.add(new Node(nx,ny,node.cnt+1));
                }
            }

        }
        return -1;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        System.out.println(bfs(0,0));


    }
}