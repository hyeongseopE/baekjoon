import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int [][] arr = new int[101][101];

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            for (int j = y; j <= endY; j++) {
                for (int k = x; k <= endX; k++) {
                    arr[j][k] ++;
                }
            }
        }

        for (int i = 0; i <101 ; i++) {
            for (int j = 0; j <101 ; j++) {
                if(arr[i][j] > m){
                    cnt ++;
                }
            }
        }
        System.out.println(cnt);


    }
}


