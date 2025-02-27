import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int []arr;
    static int []visit ;
    static boolean []chk;
    static int cnt;

    static void dfs(int x){
        visit[x] = 1;

        if(visit[arr[x]] == 0){
            dfs(arr[x]);
        }else if(!chk[arr[x]]){
            for (int i = arr[x]; i != x ; i = arr[i]) {
                cnt++;
            }
            cnt++;
        }
        chk[x] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(br.readLine());
            cnt = 0;

            arr = new int[n+1];
            chk = new boolean[n+1];
            visit = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n ; j++) {
                if(visit[j] == 0){
                    dfs(j);
                }
            }

            sb.append(n-cnt+"\n");
        }


        System.out.println(sb);


    }
}


