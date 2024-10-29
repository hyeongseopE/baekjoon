import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [][]dp = new int [k+1][n+1];


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int kg = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= k ; j++) {
                if(j >= kg){
                    if(dp[j][i-1] < dp[j-kg][i-1] + v) {
                        dp[j][i] = dp[j-kg][i-1]+ v;
                    }else {
                        dp[j][i] = dp[j][i-1];
                    }
                }else{
                    dp[j][i] = dp[j][i-1];
                }

            }
        }

        

        System.out.println(dp[k][n]);

    }
}


