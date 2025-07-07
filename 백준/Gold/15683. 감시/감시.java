import java.io.*;
import java.util.*;

public class Main {

    static int []dy = {-1,1,0,0};
    static int []dx = {0,0,-1,1};
    static int n,m,ans=Integer.MAX_VALUE;
    static int [][][]cctv_dir = {
            { {} },                                         //0 아무것도없음
            { {0},{1},{2},{3} },                            //1
            { {0, 1},{2, 3} },                              //2
            { {0, 3},{3, 1},{2, 1},{2, 0} },                //3
            { {0, 3, 1},{3, 1, 2},{0, 2, 1},{2, 0, 3} },    //4
            { {0,1,2,3} }                                   //5
    };

    static int [][]map ;
    static ArrayList<CCTV> list ;
    static class CCTV{
        int y,x,number;
        public CCTV (int y, int x, int number) {
            this.y = y;
            this.x = x;
            this.number = number;
        }
    }

    static void dfs(int dept,int[][] currentMap){

        if(dept == list.size()){
            int cnt = getBlind(currentMap);
            ans = Math.min(cnt,ans);
            return;
        }

        CCTV current = list.get(dept);
        int [][][] dirs = cctv_dir;
        for (int i = 0; i < cctv_dir[current.number].length; i++) {
            int [][]tmpMap = copyMap(currentMap);
            fillMap(cctv_dir[current.number][i], current, tmpMap);
            dfs(dept+1,tmpMap);
        }
    }

    static void fillMap(int []dirs, CCTV cctv, int [][]tmpMap){
        for(int dir : dirs){
            int ny = cctv.y;
            int nx = cctv.x;
            while(true){
                ny += dy[dir];
                nx += dx[dir];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) break;
                if(tmpMap[ny][nx] == 6) break;
                if(tmpMap[ny][nx] == 0){
                    tmpMap[ny][nx] = -1;
                }
            }

        }
    }

    static int[][] copyMap(int[][] map){
        int [][]copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(map[i], m);
        }
        return copy;

    }

    static int getBlind (int [][]map) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    cnt ++;
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

        map = new int [n][m];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                if(input > 0 && input < 6){
                    list.add(new CCTV(i,j,input));
                }
                map[i][j] = input;
            }
        }

        dfs(0,map);
        System.out.println(ans);


    }
}