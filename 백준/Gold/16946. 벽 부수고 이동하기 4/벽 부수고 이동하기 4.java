import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int [][]map ;
    static int [][]visit;
    static int [][]ans;
    static int []ty = {-1,1,0,0};
    static int []tx = {0,0,-1,1};
    static int n,m,cnt;
    static Map<Integer,Integer> chk = new HashMap();


    static void dfs(int y,int x,int cnt){
        map[y][x] = cnt;
        for (int i = 0; i < 4; i++) {
            int ny = y + ty[i];
            int nx = x + tx[i];
            if( ny < 0 || ny >= n || nx < 0 || nx >= m  ){continue;}
            if(map[ny][nx] == 0 && visit[ny][nx] == 0){
                visit[ny][nx] = 1;
                chk.put(cnt, chk.get(cnt)+1);
                dfs(ny,nx,cnt);
            }
        }
    }

    static void ansChk(int y,int x){
        Set<Integer> ansVisit = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int ny = y + ty[i];
            int nx = x + tx[i];
            if( ny < 0 || ny >= n || nx < 0 || nx >= m){continue;}
            if(map[ny][nx] != 1 && ansVisit.add(map[ny][nx])){
                ans[y][x] += chk.get(map[ny][nx]);
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
        cnt = 2;

        map = new int[n][m];
        visit = new int[n][m];
        ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0 && visit[i][j] == 0){
                    visit[i][j] = 1;
                    chk.put(cnt,1);
                    dfs(i,j,cnt++);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m ; j++) {
                if(map[i][j] == 1){
                    ans[i][j]++;
                    ansChk(i,j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ans[i][j] % 10);
            }
            System.out.println();
        }


    }
}


