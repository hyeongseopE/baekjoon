import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static char [][] arr;
    static int [][] map;
    static int []tx = {-1,1,0,0,-1,-1,1,1};
    static int [] ty = {0,0,-1,1,-1,1,-1,1};
    public static void chk(int x, int y){

        for (int i = 0; i < 8; i++) {
            int nx = x + tx[i];
            int ny = y + ty[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m){continue;}
            if(arr[nx][ny] == '*'){
                map[x][y]++;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new char [n][m];
            map = new int [n][m];
            if( n == 0 && m == 0){break;}

            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < m ; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] == '.'){
                        chk(i,j);
                    }
                    if(arr[i][j] == '*'){
                        map[i][j] = -1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] == -1){
                        System.out.print('*');
                    }else{
                        System.out.print(map[i][j]);
                    }
                }
                System.out.println("");
            }

            
        }


    }
}