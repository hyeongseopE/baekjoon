
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int [] tx = {-1,1,0,0};
    static int [] ty = {0,0,-1,1};
    static int[][] arr ;
    static boolean [][] check;
    static class Node{
        int X;
        int Y;
        public Node(int x,int y){
            this.X=x;
            this.Y=y;
        }

        public int getX() {
            return this.X;
        }
        public int getY(){
            return this.Y;
        }
    }
    public static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y));
        check[y][x] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();

            for (int i=0; i<4; i++){
                int nx = x + tx[i];
                int ny = y + ty[i];

                if (nx < 0 || nx >= arr[0].length || ny <0 || ny >= arr.length){continue;}
                if (arr[ny][nx] == 0){continue;}
                if (arr[ny][nx] == 1 && !check[ny][nx]){
                    check[ny][nx] = true;
                    queue.offer(new Node(nx,ny));
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        int cnt ;
        for (int l = 0; l < t; l++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[m][n];
            check = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {             // 0값 입력
                    arr[i][j] = 0;
                }
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int inputX = Integer.parseInt(st.nextToken());      //좌표에 배추심기
                int inputY = Integer.parseInt(st.nextToken());
                arr[inputY][inputX] = 1;
            }

//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(arr[i][j] + " ");      // 배추심은 배열 출력
//                }
//                System.out.println();
//            }
            cnt = 0;
            for (int i =0; i<m; i++){
                for (int j = 0; j<n;j++){
                    if (arr[i][j] == 1 && !check[i][j]){         // bfs 돌리고 나오는 기준으로 지렁이 갯수 카운터++
                        bfs(j,i);
                        cnt ++;
                    }
                }
            }
            System.out.println(cnt);
        }


    }
}



