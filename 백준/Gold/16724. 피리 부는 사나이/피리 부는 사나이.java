import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {

    static int []dy = {-1,1,0,0};
    static int []dx = {0,0,-1,1};
    static int circle = 1 ,n,m;
    static int [][]map;
    static int [][]visit;

    static void dfs(int y, int x,int c){

        if(visit[y][x] == c){
            circle ++ ;
            return ;
        }else if (visit[y][x] != c && visit[y][x] != 0){
            return;
        }

        int d = map[y][x];
        int nextY = y + dy[d];
        int nextX = x + dx[d];

        visit[y][x] = circle;
        dfs(nextY,nextX,c);

        if(visit[nextY][nextX] != c && visit[nextY][nextX] != 0 ){
            visit[y][x] = visit[nextY][nextX];
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int [n][m];
        visit = new int [n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = input.charAt(j);
                if(c == 'U'){map[i][j] = 0;}
                else if(c == 'D'){map[i][j] = 1;}
                else if(c == 'L'){map[i][j] = 2;}
                else {map[i][j] = 3;}
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visit[i][j] == 0){
                    dfs(i,j,circle);
                }
            }
        }

        System.out.println(circle-1);






    }
}