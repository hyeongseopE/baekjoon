import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static List<Integer>[]graph;
    static int n,r,q;
    static int []cnt;

    static void dfs(int r,int prev){

        for (int i = 0; i < graph[r].size(); i++) {
            int x = graph[r].get(i);
            if(x == prev){continue;}
            dfs(x,r);
            cnt[r] += cnt[x];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        cnt = new int[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            cnt[i] = 1;
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(r,-1);

        for (int i = 0; i < q; i++) {
            int qa = Integer.parseInt(br.readLine());
            sb.append(cnt[qa]+"\n");
        }
        System.out.println(sb);


    }
}


