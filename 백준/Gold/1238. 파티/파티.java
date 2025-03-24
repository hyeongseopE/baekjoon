import java.io.*;
import java.util.*;

public class Main {
    static List<Edge> []graph;
    static List<Edge> []graph2;
    static int n,m,s;
    static int []dp1;
    static int []dp2;

    static class Edge implements Comparable<Edge>{
        int v,cost;
        public Edge(int v, int cost){
            this.v=v;
            this.cost=cost;
        }

        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost;
        }
    }

    static void dijkstra(int s){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(s,0));
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            int nowCost = now.cost;
            if(dp1[now.v] < nowCost){continue;}

            for (int i = 0; i < graph[now.v].size(); i++) {
                Edge next = graph[now.v].get(i);
                int nextCost = nowCost+next.cost;
                if(nextCost < dp1[next.v]){
                    dp1[next.v] = nextCost;
                    pq.add(new Edge(next.v,nextCost));
                }
            }
        }
    }

    static void dijkstra2(int s){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(s,0));
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            int nowCost = now.cost;
            if(dp2[now.v] < nowCost){continue;}

            for (int i = 0; i < graph2[now.v].size(); i++) {
                Edge next = graph2[now.v].get(i);
                int nextCost = nowCost+next.cost;
                if(nextCost < dp2[next.v]){
                    dp2[next.v] = nextCost;
                    pq.add(new Edge(next.v,nextCost));
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        int ans = 0;

        graph = new ArrayList[n+1];
        graph2 = new ArrayList[n+1];
        dp1 = new int[n+1];
        dp2 = new int[n+1];
        Arrays.fill(dp1,Integer.MAX_VALUE);
        Arrays.fill(dp2,Integer.MAX_VALUE);
        dp1[s] = 0;
        dp2[s] = 0;

        for (int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
            graph2[i] = new ArrayList<>();
        }



        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[v1].add(new Edge(v2,cost));
            graph2[v2].add(new Edge(v1,cost));
        }
        dijkstra(s);
        dijkstra2(s);

        for (int i = 1; i <= n ; i++) {
            if(dp1[i] != Integer.MAX_VALUE || dp2[i] != Integer.MAX_VALUE){
                dp1[i] += dp2[i];
                ans = Math.max(dp1[i],ans);
            }
        }

        System.out.println(ans);





    }
}


