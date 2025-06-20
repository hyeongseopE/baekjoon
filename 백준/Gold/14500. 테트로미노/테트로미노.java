import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int [][]map;
    static int[][][] tetX = {
            {{1,2,3}, {0,0,0}},               // ㅡ
            {{1,1,0}},                       // ㅁ
            {{0,0,1}, {-1,-2,-2}, {0,0,-1},{1,2,2},{0,0,-1},{-1,-2,-2},{0,0,1},{1,2,2}},   // ㄴ
            {{0,1,1}, {-1,-1,-2}, {0,-1,-1},{1,1,2},{0,-1,-1},{-1,-1,-2},{0,1,1},{1,1,2}},   // ㄴㄱ
            {{1,2,1}, {0,0,-1}, {-1,-2,-1},{0,0,1},{1,2,1},{0,0,1},{-1,-2,-1},{0,0,-1}}  // ㅗ
    };

    static int[][][] tetY = {
            {{0,0,0}, {1,2,3}},               // ㅡ
            {{0,1,1}},                       // ㅁ
            {{1,2,2}, {0,0,1}, {-1,-2,-2}, {0,0,-1},{1,2,2},{0,0,-1},{-1,-2,-2},{0,0,1}},   // ㄴ
            {{1,1,2}, {0,1,1}, {-1,-1,-2}, {0,-1,-1},{1,1,2},{0,-1,-1},{-1,-1,-2},{0,1,1}},   // ㄴㄱ
            {{0,0,1}, {1,2,1}, {0,0,-1}, {-1,-2,-1},{0,0,-1},{1,2,1},{0,0,1},{-1,-2,-1}}  // ㅗ
    };




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int max_value = 0;


        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < tetX[k].length; l++) {
                        int sum = map[i][j];
                        boolean chk = true;
                        for (int o = 0; o < tetX[k][l].length; o++) {
                            int ty = i + tetY[k][l][o];
                            int tx = j + tetX[k][l][o];
                            if(ty < 0 || ty >= n || tx < 0 || tx >= m){
                                chk = false;
                                break;
                            }
                            sum += map[ty][tx];
                        }
                        if(chk) {max_value = Math.max(max_value, sum);}
                    }
                }
            }
        }

        System.out.println(max_value);


    }
}