import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n,m,cnt;
    static int []arr;
    static int []prev;
    static List<Node> []graph;
    static class Node implements Comparable<Node>{
        int y,cost;
        public Node(int y,int cost){
            this.y=y;
            this.cost=cost;
        }
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    static void dijkstra(int s){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s,0));
        arr[s]=0;
        prev[s]=-1;
        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(arr[node.y] < node.cost){continue;}

            for(Node n : graph[node.y]){
                if(arr[n.y] > arr[node.y]+n.cost){
                    arr[n.y] = arr[node.y]+n.cost;
                    prev[n.y] = node.y;
                    pq.add(new Node(n.y,arr[n.y]));
                }
            }
        }

    }
    static void back(int x){
        if(x == -1){return;}
        back(prev[x]);
        sb.append(x+" ");
        cnt++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new int [n+1];
        prev = new int [n+1];
        Arrays.fill(arr,Integer.MAX_VALUE);
        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int cost1 = Integer.parseInt(st.nextToken());

            graph[x1].add(new Node(y1,cost1));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());


        dijkstra(s);
        back(v);

//        for (int i = 1; i <=n ; i++) {
//            System.out.println("arr["+i+"]:"+arr[i]);
//        }
//        for (int i = 1; i <= n ; i++) {
//            System.out.println("prev["+i+"]:"+prev[i]);
//        }
        System.out.println(arr[v]+"\n"+cnt+"\n"+sb);



    }
}


