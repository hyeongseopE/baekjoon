import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int [][]dp = new int[n+1][4];


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        for (int i = 1; i <= n ; i++) {
            dp[i][1] += Math.min(dp[i-1][2],dp[i-1][3]);
            dp[i][2] += Math.min(dp[i-1][1],dp[i-1][3]);
            dp[i][3] += Math.min(dp[i-1][1],dp[i-1][2]);
        }

        System.out.println(Math.min(dp[n][1],Math.min(dp[n][2],dp[n][3])));


    }
}


