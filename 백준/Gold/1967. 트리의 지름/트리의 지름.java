import java.io.*;
import java.util.*;

public class Main {
    public static List<Node>[] graph;
    public static int []arr ;
    public static int []vitsit ;
    static int n;

    static int find_V(int[] arr){
        int max_index=1;
        for (int i = 1; i < n+1; i++) {
            if(arr[max_index] < arr[i]){
                max_index = i;
            }
        }
        return max_index;
    }
    static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        vitsit[n] = 1;
        while(!q.isEmpty()){
            int x = q.poll();
            for (int i = 0; i < graph[x].size(); i++) {
                int nx = graph[x].get(i).d;
                if(vitsit[nx] == 0){
                    q.add(nx);
                    arr[nx] = arr[x]+graph[x].get(i).cost;
                    vitsit[nx] = 1;
                }
            }
        }
    }

    static class Node{
        int d,cost;
        public Node(int d,int cost){
            this.d=d;
            this.cost=cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        arr = new int [n+1];
        vitsit = new int [n+1];
        for (int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[x1].add(new Node(y1,c));
            graph[y1].add(new Node(x1,c));
        }
        bfs(1);
        int v = find_V(arr);
        arr = new int[n+1];
        vitsit = new int[n+1];
        bfs(v);
        int v2 = find_V(arr);
        System.out.println(arr[v2]);



    }

}
