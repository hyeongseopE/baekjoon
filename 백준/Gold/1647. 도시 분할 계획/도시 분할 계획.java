import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int []union ;
    static ArrayList<Node> list = new ArrayList<>();

    static class Node{
        int x,y,cost;
        public Node(int x,int y,int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int dfs(int x){

        if(union[x]==x){return union[x];}
        return union[x] = dfs(union[x]);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cost = 0;
        int cnt = 0;

        union = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            union[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int cost1 = Integer.parseInt(st.nextToken());
            list.add(new Node(x1,y1,cost1));
        }
        list.sort((o1, o2) -> o1.cost - o2.cost);

        for(Node node : list){

            int union1 = dfs(node.x);
            int union2 = dfs(node.y);

            if(union1 != union2){
//                System.out.println("x: "+node.x+" y:"+node.y+" cost: "+node.cost);
                union[union2] = union1;
                cost += node.cost;
                cnt ++;
            }

            if(cnt == n-1){
                cost -= node.cost;
                break;
            }
        }

//        for (int i = 1; i < union.length; i++) {
//            System.out.println(i+": "+union[i]+" cost: "+cost);
//        }

        System.out.println(cost);



    }
}