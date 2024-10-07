import java.io.*;
import java.util.*;

public class Main {
    static int [][]map = new int [101][101];
    static int [][]map2 = new int [101][101];
    static int [][]vitsit = new int [101][101];
    static int []tx = {-1,1,0,0};
    static int []ty = {0,0,-1,1};
    static int n;

    public static class Node{
        int x,y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void bfs(int x,int y,int c,int c2){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        vitsit[x][y] = 1;
        while(!q.isEmpty()){
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x+tx[i];
                int ny = node.y+ty[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n){continue;}
                if(vitsit[nx][ny] == 0 && (map[nx][ny] == c || map[nx][ny] == c2)){
                    vitsit[nx][ny] = 1;
                    q.add(new Node(nx,ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int cnt1=0,cnt2=0;
        for (int i = 0; i <n ; i++) {
            String input = br.readLine();
            for (int j = 0; j <n; j++) {
                if(input.charAt(j) == 'R'){
                    map[i][j] = 1;
                }
                if(input.charAt(j) == 'G'){
                    map[i][j] = 2;
                }
                if(input.charAt(j) == 'B'){
                    map[i][j] = 3;
                }

            }
        }



        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if(vitsit[j][k] == 0){
                    bfs(j,k,map[j][k],map[j][k]);
                    cnt1++;
                }
            }
        }

        vitsit = new int[101][101];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(vitsit[i][j] == 0){
                    if(map[i][j] != 3){
                        bfs(i,j,1,2);
                        cnt2++;
                    }else{
                        bfs(i,j,3,3);
                        cnt2++;
                    }
                }
            }
        }

        System.out.println(cnt1+"\n"+cnt2);
    }
}