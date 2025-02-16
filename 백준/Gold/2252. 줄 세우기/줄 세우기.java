import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[]graph ;
    static int []inDegree ;
    static int n,m;
    static StringBuilder sb = new StringBuilder();

    static void TS(){
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= n ; i++) {
            if(inDegree[i] == 0){
                dq.add(i);
            }
        }
        while(!dq.isEmpty()){
            int x = dq.pop();
            sb.append(x+" ");
            for (int i = 0; i < graph[x].size(); i++) {
                int target = graph[x].get(i);
                if(--inDegree[target] == 0){
                    dq.addFirst(target);
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

        graph = new ArrayList[n+1];
        inDegree = new int[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            graph[x1].add(y1);
            inDegree[y1]++;
        }

        TS();

        System.out.println(sb);



    }
}


