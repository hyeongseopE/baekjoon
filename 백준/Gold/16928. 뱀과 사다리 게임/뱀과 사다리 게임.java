import java.io.*;
import java.util.*;

public class Main {
    static int []map = new int [150];
    static int []vitsit = new int [150];
    static int []ledder = new int [150];

    static int n,m;

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while(true){
            int node = q.poll();

//            System.out.println("node : "+node+" vitsit["+node+"] : "+vitsit[node]);
            if(node == 100){break;}

            if(ledder[node] != 0 && ledder[node] > node){
                q.add(ledder[node]);
                vitsit[ledder[node]] = vitsit[node];
                continue;
            }else if(ledder[node] != 0 && ledder[node] < node){
                q.add(ledder[node]);
                vitsit[ledder[node]] = vitsit[node];
                continue;
            }

            for (int i = 1; i <= 6; i++) {
                int xNode = node + i;
                if(vitsit[xNode] == 0 || vitsit[node] < vitsit[xNode]){
                    q.add(xNode);
                    vitsit[xNode] = vitsit[node] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            ledder[x1] = y1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            ledder[x1] = y1;
        }


        bfs(1);

        System.out.println(vitsit[100]);

    }
}