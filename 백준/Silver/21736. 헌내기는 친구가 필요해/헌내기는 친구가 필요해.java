import java.io.*;
import java.util.*;

public class Main {
    static String arr [][] = new String [601][601];


    static int n,cnt;
    static int m;
    static int tx [] = {-1,1,0,0};
    static int ty [] = {0,0,-1,1};
    static boolean chk [][] = new boolean[601][601];


    static public class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }

    }
    static int bfs (int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        chk[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();


            for (int i = 0; i < 4; i++) {
                int nx = node.x + tx[i];
                int ny = node.y + ty[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){continue;}
                if(!chk[nx][ny] && (arr[nx][ny].equals("O") || arr[nx][ny].equals("P"))){
                    chk[nx][ny] = true;
                    q.add(new Node(nx,ny));
                    if(arr[nx][ny].equals("P")){
                        cnt++;
                    }
                }
            }

        }
        return cnt;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int a=0,b=0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                String input = String.valueOf(s.charAt(j));
                if(input.equals("I")){
                    a=i;b=j;
                    arr[i][j] = input;
                }else{
                    arr[i][j] = input;
                }


            }
        }

        if(bfs(a,b) > 0){
            System.out.println(cnt);
        }else{
            System.out.println("TT");
        }


    }
}