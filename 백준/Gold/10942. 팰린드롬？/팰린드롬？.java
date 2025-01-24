import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int []arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int []arr = new int[n+1];

        for (int i = 1; i <= n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        int [][]dp = new int[n+1][n+1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                dp[i][j] = 1;
            }
        }

        for (int i = 1; i <= n-1 ; i++) {
            if(arr[i]==arr[i+1]){
                dp[i][i+1] = 1;
            }
        }


        for (int i = n-1; i >= 1 ; i--) {
            for (int j = i+2; j <= n ; j++) {
                if(arr[i] == arr[j] && dp[i+1][j-1]==1){
                    dp[i][j] = 1;
                }
            }
        }
        

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e]+"\n");
        }
        System.out.println(sb);




    }

}
