import java.io.*;
import java.util.*;

public class Main {
    static final int VALUE = 1000*1000+1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int [][]dp = new int[n+1][4];
        int [][]cost = new int[n+1][4];
        int ans = VALUE;


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 3 ; i++) {

            for (int j = 1; j <=n ; j++) {
                Arrays.fill(dp[j],VALUE);
            }

           dp[1][i] = cost[1][i];
            for (int j = 1; j < n ; j++) {
                dp[j+1][1] = Math.min(dp[j][2],dp[j][3])+cost[j+1][1];
                dp[j+1][2] = Math.min(dp[j][1],dp[j][3])+cost[j+1][2];
                dp[j+1][3] = Math.min(dp[j][1],dp[j][2])+cost[j+1][3];
            }
            
            for (int j = 1; j <= 3 ; j++) {
                if(j != i && dp[n][j] < ans){
                    ans = dp[n][j];
                }
            }
        }
        System.out.println(ans);


    }
}


