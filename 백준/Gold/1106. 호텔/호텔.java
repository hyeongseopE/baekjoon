import java.io.*;
import java.net.Inet4Address;
import java.util.*;
import java.util.Stack;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int [][]arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());  // 비용
            arr[i][1] = Integer.parseInt(st.nextToken());  // 인원
        }
        int maxCost = 100 * c;
        int []dp = new int [maxCost+1];
        for (int cost = 0; cost <= maxCost; cost++) {
            for (int i = 0; i < n; i++) {
                int advCost = arr[i][0];
                int advPerson = arr[i][1];

                if (cost + advCost <= maxCost) {
                    dp[cost + advCost] = Math.max(dp[cost + advCost], dp[cost] + advPerson);
                }
            }
        }

        for (int i = 0; i <= maxCost; i++) {
            if (dp[i] >= c) {
                System.out.println(i);
                break;
            }
        }


    }
}


