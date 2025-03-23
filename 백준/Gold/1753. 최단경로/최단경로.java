import java.io.*;
import java.util.*;

public class Main {
    static List<Edge>[] graph;
    static int []dp;
    static public class Edge implements Comparable<Edge>{
        int v,cost;
        public Edge(int v,int cost){
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o1){
            return this.cost - o1.cost;
        }
    }

    static void dijkstra(int k){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(k,0));

        while(!pq.isEmpty()){
            Edge x = pq.poll();
            int xv = x.v;
            int xCost = x.cost;
            if(dp[xv] < xCost){continue;}

            for (int i = 0; i < graph[x.v].size(); i++) {
                Edge edge = graph[x.v].get(i);
                int nextCost = xCost+edge.cost;
                if(nextCost < dp[edge.v]){
                    dp[edge.v] = nextCost;
                    pq.add(new Edge(edge.v,nextCost));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        graph = new ArrayList[v+1];
        dp = new int[v+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[k] = 0;
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[v1].add(new Edge(v2,w));
        }
        dijkstra(k);

        for (int i = 1; i <= v ; i++) {
            if(dp[i] == Integer.MAX_VALUE){
                System.out.println("INF");
                continue;
            }
            System.out.println(dp[i]);
        }



    }
}


