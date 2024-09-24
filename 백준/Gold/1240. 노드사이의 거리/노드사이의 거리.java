import java.io.*;
import java.util.*;

public class Main {
    static int n,m,ans;
    public static class Node{
        int y,d;
        public Node(int y,int d){
            this.y=y;
            this.d=d;
        }

        public int getY(){
            return y;
        }

        public int getD(){
            return d;
        }
    }

    static int []chk ;

    public static void dfs(int x1,int y1,int dap){
        chk[x1] = 1;
        for (int i = 0; i < graph.get(x1).size(); i++) {
            int ny = graph.get(x1).get(i).getY();
            if(ny == y1){
                ans = dap+graph.get(x1).get(i).getD();
                return ;
            }else if(chk[ny] == 0){
                dfs(ny,y1,dap+graph.get(x1).get(i).getD());

            }
        }
    }
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 1001; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());

            graph.get(x1).add(new Node(y1,d1));
            graph.get(y1).add(new Node(x1,d1));

//            System.out.println(graph.get(x1).get(0).getY()+" "+graph.get(y1).get(0).getY());

        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            ans = 0;
            chk = new int [1001];
            dfs(x1,y1,0);
            sb.append(ans+"\n");
        }
        System.out.println(sb);





    }
}