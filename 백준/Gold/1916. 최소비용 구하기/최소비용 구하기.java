import java.io.*;
import java.util.*;

public class Main {
    public static List<Node>[] graph;
    public static int[] dist;

    public static class Node implements Comparable<Node> {
        int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int v = node.v;
            int cost = node.cost;

            if (dist[v] < cost) continue;

            for (Node e : graph[v]) {
                if (dist[e.v] > dist[v] + e.cost) {
                    dist[e.v] = dist[v] + e.cost;
                    pq.add(new Node(e.v, dist[e.v]));
                }
            }
        }

        System.out.println(dist[end]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());  // 도시의 개수
        int m = Integer.parseInt(br.readLine());  // 버스의 개수

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[v].add(new Node(w, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());  
        int e = Integer.parseInt(st.nextToken());

        dijkstra(s, e);
    }
}
