import java.io.*;
import java.util.*;

public class Main {
    static int t,n,k,endPoint;
    static List<Integer>[] graph;
    static int []cost ;
    static int []arr ;
    static int []dp ;
    static void TS(int end){
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(arr[i] == 0){
                q.add(i);
                dp[i] = cost[i];
            }
        }
        while(!q.isEmpty()){
            int x = q.poll();

            for(Integer p : graph[x]){
                dp[p] = Math.max(dp[p],dp[x]+cost[p]);
                if(--arr[p] == 0){
                    q.add(p);
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n+1];
            cost = new int[n+1];
            arr = new int[n+1];
            dp = new int[n+1];

            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                cost[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                graph[x1].add(y1);
                arr[y1]++;
            }
            endPoint = Integer.parseInt(br.readLine());
            TS(endPoint);
            sb.append(dp[endPoint]+"\n");

        }

        System.out.println(sb);



    }
}


