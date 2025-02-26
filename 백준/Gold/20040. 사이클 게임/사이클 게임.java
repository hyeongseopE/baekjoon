import java.io.*;
import java.util.*;

public class Main {
    static int []union ;

    static int dfs(int x){

        if(union[x] == x){return union[x];}
        return dfs(union[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;

       union = new int[n+1];

        for (int i = 0; i < n; i++) {
            union[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int find1 = dfs(x1);
            int find2 = dfs(y1);
            if(find1 != find2){

                union[find2] = find1;
                cnt ++;

            }else {
                cnt ++;
                System.out.println(cnt);
                break;
            }

            if(cnt == m ){
                System.out.println("0");
            }

        }







    }
}