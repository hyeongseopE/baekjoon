import java.io.*;
import java.util.*;

public class Main {
    static int [][]map ;
    static int [][]chk ;
    static int []tx = {-1,0,1,0};
    static int []ty = {0,-1,0,1};
    static int currentX = 0, currentY = 0,n,ans,eatCnt,eating;
    static PriorityQueue<Node> pq ;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;
                if(x == 9){
                    currentX = i;
                    currentY = j;
                }
            }
        }

        int size = 2;
        while(true) {
            chk = new int[n][n];

            bfs(currentX, currentY, size);

            eatFish(size);
            if(eating == 1){
                eatCnt ++;
                eating = 0;
                if(eatCnt == size){
                    size ++;
                    eatCnt = 0;
                }
            }else {
                break;
            }
        }

        System.out.println(ans);


    }
    public static void bfs(int x,int y,int size){
        Queue<Node> q = new LinkedList<>();
        pq = new PriorityQueue<>();
        chk[x][y] = 1;
        q.add(new Node(x,y,chk[x][y]));
        while(!q.isEmpty()){
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x+tx[i];
                int ny = node.y+ty[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n){continue;}
                if(chk[nx][ny] == 0 && map[nx][ny] <= size ){
                    chk[nx][ny] = chk[node.x][node.y] + 1;
                    q.add(new Node(nx,ny,chk[nx][ny]));
                    pq.add(new Node(nx,ny,chk[node.x][node.y]+1));
                }
            }
        }
    }

    public static void eatFish(int size){
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(map[node.x][node.y] != 0 && map[node.x][node.y] < size){
                ans += (node.cost-1);
                eating = 1;
                map[node.x][node.y] = 9;
                map[currentX][currentY] = 0;
                currentX = node.x; currentY=node.y;
                break;
            }
        }

    }
    public static class Node implements Comparable<Node>{
        int x,y,cost;
        public Node(int x,int y,int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            if(this.cost == o.cost){
                if(this.x == o.x){
                    return this.y - o.y;
                }else{
                    return this.x - o.x;
                }
            }
            return this.cost - o.cost;
        }
    }
}
