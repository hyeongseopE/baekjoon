import java.io.*;
import java.util.*;

public class Main {
    static int n,m,t,x1,y1,x2,y2;
    static int [][]map ;
    static int [][]chk ;
    static int []tx = {-1,1,0,0};
    static int []ty = {0,0,-1,1};

    static Queue<Node> q = new LinkedList<>();
    static class Node{
        int x,y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    static void inBfs(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]>0){
                    q.add(new Node(i,j));
                }
            }
        }
    }
    static void bfs(int size){
        for (int i = 0; i < size; i++) {
            Node node = q.poll();
            int minus = 0;
            for (int j = 0; j < 4; j++) {
                int nx = node.x + tx[j];
                int ny = node.y + ty[j];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){continue;}
                if(map[nx][ny] < 0){continue;}
                chk[nx][ny] += map[node.x][node.y]/5;
                minus += map[node.x][node.y]/5;
            }
            map[node.x][node.y] -= minus;
        }
    }

    static int right(int x,int t){
        int t2=0;
        for (int i = 1; i < m-1; i++) {
            t2 = map[x][i+1];map[x][i+1]=t;t=t2;
        }
        return t;
    }
    static int up(int x,int t,int r,int r2){
        int t2=0;
        for (int i = x; i > r ; i--) {
            if(map[i-1][r2] < 0){return t;}
            t2 = map[i-1][r2];map[i-1][r2]=t;t=t2;
        }
        return t;
    }
    static int left(int x ,int t){
        int t2=0;
        for (int i = m-1; i > 0; i--) {
            t2 = map[x][i-1];map[x][i-1]=t;t=t2;
        }
        return t;
    }
    static int down(int x,int t,int r,int r2){
        int t2 = 0;
        for (int i = x; i < r; i++) {
            if(map[i+1][r2] < 0){return t;}
            t2 = map[i+1][r2];map[i+1][r2]=t;t=t2;
        }
        return t;
    }

    static void air(int x){
        int t=map[x][1];
        map[x][1] = 0;
        t=right(x,t);
        t=up(x,t,0,m-1);
        t=left(0,t);
        down(0,t,x,0);
    }
    static void air2(int x){
        int t = map[x][1];
        map[x][1]=0;
        t=right(x,t);
        t=down(x,t,n-1,m-1);
        t=left(n-1,t);
        up(n-1,t,x,0);


    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        int cnt=0;
        int ans=0;
        map = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                if(input == -1){
                    cnt ++;
                    if(cnt == 1){
                        x1=i;
                    }
                }
                if(cnt == 2){
                    map[i][j] = -2;
                    x2=i;
                    cnt=0;
                    continue;
                }
                map[i][j] = input;
            }
        }


        while(t!=0) {
            chk = new int[n][m];
            inBfs();
            bfs(q.size());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] += chk[i][j];
                }
            }
            air(x1);
            air2(x2);
            t--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]>0){
                    ans += map[i][j];
                }
            }
        }

        System.out.println(ans);

    }
}


