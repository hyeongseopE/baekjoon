import java.io.*;
import java.util.*;

public class Main {
    static int [][]map = new int [251][251];
    static boolean [][]vitsit = new boolean[251][251];
    static int [] tx = {-1,1,0,0};
    static int [] ty = {0,0,-1,1};
    static int n,m,cntV,cntK,max_V,max_K;


    static public class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    static public void bfs(int x,int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        vitsit[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            if(map[node.x][node.y] == 1){
                cntV ++;
            }
            if (map[node.x][node.y] == 2){
                cntK ++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + tx[i];
                int ny = node.y + ty[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){continue;}
                if(map[nx][ny] != -1 && !vitsit[nx][ny]){
                    q.add(new Node(nx,ny));
                    vitsit[nx][ny] = true;
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if(s.charAt(j) == '.') {
                    map[i][j] = 0;
                }else if (s.charAt(j) == '#'){
                    map[i][j] = -1;
                }else if (s.charAt(j) == 'v'){
                    map[i][j] = 1;
                }else if (s.charAt(j) == 'k'){
                    map[i][j] = 2;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                cntV=0;
                cntK=0;
                if (map[j][k]  != -1  && !vitsit[j][k]) {
                    bfs(j,k);
                    if(cntV < cntK){
                        max_K += cntK;
                    }else {
                        max_V += cntV;
                    }
                }
            }
        }

        System.out.println(max_K+" "+max_V);

    }
}