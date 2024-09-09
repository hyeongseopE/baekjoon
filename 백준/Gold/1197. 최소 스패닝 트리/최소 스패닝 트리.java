import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node> list = new ArrayList<>();
    static int[] arr = new int [10010];
    static int n, m, ans, cnt;




    public static class Node{
        int x,y,p;
        public Node(int x,int y,int p){
            this.x=x;
            this.y=y;
            this.p=p;
        }
    }

    public static int dfs(int d){

        if(arr[d] == d){return arr[d];}
        arr[d] = dfs(arr[d]);
        return arr[d];

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            st=new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            list.add(new Node(x1,y1,p1));
        }

        list.sort((o1, o2) -> o1.p - o2.p);
        for (Node node : list) {

            int ch1 = dfs(node.x);
            int ch2 = dfs(node.y);

            if(ch1 != ch2){
                arr[ch2] = ch1;
                ans += node.p;
                cnt++;
            }
            if(cnt == n-1){
                break;
            }

        }
        System.out.println(ans);





    }
}