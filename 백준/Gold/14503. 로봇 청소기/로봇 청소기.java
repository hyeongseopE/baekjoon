import java.io.*;
import java.util.*;

public class Main {
    static int n,m,cnt,ans;
    static int [][] map ;
    static int [][] vitsit;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};

    static class Robot {
        int x,y,d;
        public Robot (int x,int y,int d) {
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }

    static void bfs(int x,int y,int d){
        vitsit[x][y] = 1;
        Queue<Robot> r = new LinkedList<>();
        r.add(new Robot(x,y,d));
        ans ++;
        while(!r.isEmpty()){
            Robot robot = r.poll();
            int currentD = robot.d;
            boolean moveChk = false;

            for (int i = 0; i < 4; i++) {
                currentD = (currentD + 3) % 4;
                int nx = robot.x + dx[currentD];
                int ny = robot.y + dy[currentD];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){continue;}
                if(map[nx][ny] == 0 && vitsit[nx][ny] == 0){
                    r.add(new Robot(nx,ny,currentD));
                    vitsit[nx][ny] = 1;
                    moveChk = true;
                    ans ++;
                    break;
                }
            }

            if(!moveChk){
                int nx = robot.x - dx[currentD];
                int ny = robot.y - dy[currentD];
                if(nx >= 0 && nx <= n && ny >= 0 && ny <= m && (map[nx][ny] == 0)){
                    r.add(new Robot(nx,ny,currentD));
                }else{
                    break;
                }
            }



        }

    }

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;

       st = new StringTokenizer(br.readLine());

       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());

       map = new int [n+1][m+1];
       vitsit = new int [n+1][m+1];

       st = new StringTokenizer(br.readLine());
       int sx = Integer.parseInt(st.nextToken());
       int sy = Integer.parseInt(st.nextToken());
       int sd = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(sx,sy,sd);

        System.out.println(ans);



    }
}
