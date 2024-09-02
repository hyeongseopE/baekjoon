import java.io.*;
import java.util.*;

public class Main {

    static int [][]map = new int [9][9];
    static int [][]vitsit = new int [9][9];
    static int [][]chk1 = new int[9][9];
    static int [][]chk2 = new int[9][9];
    static int [][]chk = new int[9][9];

    static int []tx = {-1,1,0,0};
    static int []ty = {0,0,-1,1};
    static int n,m,bcnt,cnt,max_Cnt;
    static ArrayList<Vnode> list = new ArrayList<>();



    static public class Vnode{
        int x,y;
        public Vnode(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    static public class Node{
        int x,y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static public int safe(){
        cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0 && vitsit[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static public void wall(int c){

        if(c == 3){
            vitsit = new int[9][9];
            for (int i = 0; i < list.size(); i++) {
                bfs(list.get(i).x,list.get(i).y);
            }
            max_Cnt = Math.max(safe(),max_Cnt);

            return ;


        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    wall(c+1);
                    map[i][j] = 0;
                }
            }
        }

    }

    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        vitsit[x][y] = 2;
        while(!q.isEmpty()){
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x+tx[i];
                int ny = node.y+ty[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){continue;}
                if(map[nx][ny] == 0 && vitsit[nx][ny] == 0){
                    q.add(new Node(nx,ny));
                    vitsit[nx][ny] = 2;
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
            for (int j = 0; j < m; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;
                if(v == 2){
                    list.add(new Vnode(i,j));
                }

            }
        }

        wall(0);
        System.out.println(max_Cnt);





    }
}