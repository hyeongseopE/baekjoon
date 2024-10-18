import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer>[] graph;
    public static int []arr ;
    public static int []vitsit ;
    static int n;

    static void bfs(int d){
        Queue<Integer> q = new LinkedList<>();
        q.add(d);
        vitsit[d] = 1;
        while(!q.isEmpty()){
            int x = q.poll();
            for (int i = 0; i < graph[x].size(); i++) {
                int nx = graph[x].get(i);
                if(vitsit[nx] == 0){
                    q.add(nx);
                    arr[nx] = x;
                    vitsit[nx] = 1;
                }
            }
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
            graph[x1].add(y1);
            graph[y1].add(x1);

        }
        bfs(1);

        for (int i = 2; i <=n ; i++) {
            System.out.println(arr[i]);
        }


    }

}
