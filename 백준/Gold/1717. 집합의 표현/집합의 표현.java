import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int [1000010];
    static int n, m, ans, cnt;


    public static int dfs(int d){

        if(arr[d] == d){return arr[d];}
        return arr[d] = dfs(arr[d]);


    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x1 = dfs(Integer.parseInt(st.nextToken()));
            int x2 = dfs(Integer.parseInt(st.nextToken()));
            if(t == 0){
                if(x1 != x2){
                    arr[x2] = x1;
                }
            }else{
                if(x1 != x2){
                    sb.append("NO").append("\n");
                }else{
                    sb.append("YES").append("\n");
                }
            }
        }

        System.out.println(sb);



    }
}