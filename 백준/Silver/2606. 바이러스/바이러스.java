import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[1001][1001];
    static int[] vitsit = new int [101];
    static int n, m, ans, cnt;




    public static class Node{
        int x,y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void bfs(int d) {
        Queue<Integer> q = new LinkedList<>();
        q.add(d);
        vitsit[d] = 1;
        while(!q.isEmpty()){
            int x = q.poll();
            for (int i = 1; i <= n; i++) {
                if(map[x][i] == 1 && vitsit[i] == 0){
                    cnt++;
                    q.add(i);
                    vitsit[i]= 1;
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for (int i = 1; i <= m; i++) {
            st=new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            map[x1][y1] = 1;
            map[y1][x1] = 1;
        }

        bfs(1);
        System.out.println(cnt);


    }
}