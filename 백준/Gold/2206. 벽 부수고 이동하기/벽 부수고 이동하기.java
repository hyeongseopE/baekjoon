import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    static int n,m;
    static int [][]map ;
    static int [][][]vitsit;
    static int []tx = {-1,1,0,0};
    static int []ty = {0,0,-1,1};
    static class Node{
        int x,y,t;
        public Node(int x,int y,int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    static void bfs(int x, int y,int t){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,t));
        vitsit[t][x][y] = 1;
        while(!q.isEmpty()){
            Node node = q.poll();
//            System.out.println("node.x : "+node.x+" node.y:"+node.y+" node.t:"+t);
            for (int i = 0; i < 4; i++) {
                int nx = node.x + tx[i];
                int ny = node.y + ty[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){continue;}
                if(vitsit[node.t][nx][ny]==0 && map[nx][ny]==0){
                    q.add(new Node(nx,ny,node.t));
                    vitsit[node.t][nx][ny] = vitsit[node.t][node.x][node.y]+1;
                }else if(map[nx][ny] == 1 && node.t ==0){
                    q.add(new Node(nx,ny,node.t+1));
                    vitsit[node.t+1][nx][ny] = vitsit[node.t][node.x][node.y]+1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        vitsit = new int [2][n][m];


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        bfs(0,0,0);



       if(vitsit[0][n-1][m-1] == 0 && vitsit[1][n-1][m-1] == 0){
           System.out.println("-1");
       }else if(vitsit[0][n-1][m-1] == 0){
           System.out.println(vitsit[1][n-1][m-1]);
       }else if (vitsit[1][n-1][m-1] == 0){
           System.out.println(vitsit[0][n-1][m-1]);
       }else{
           System.out.println(Math.min(vitsit[0][n-1][m-1],vitsit[1][n-1][m-1]));
       }

    }
}

