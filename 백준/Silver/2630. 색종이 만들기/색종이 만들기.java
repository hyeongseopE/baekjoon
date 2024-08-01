import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    static int [][] arr = new int [129][129];
    static int cntW = 0;
    static int cntB = 0;
    static boolean chk ;
    static public void map (int x, int y, int m,int v){

        chk = true;
        for (int i = x; i < x+m ; i++) {
            for (int j = y; j < y+m; j++) {
                if(arr[i][j] != v){
                    chk = false;
                }
            }
        }
        if(chk){
            if(v == 1){
                cntB += 1;
                return;
            }else{
                cntW += 1;
                return;
            }
        }

        map(x,y,m/2,arr[x][y]);
        map(x,y+m/2,m/2,arr[x][y+m/2]);
        map(x+m/2,y,m/2,arr[x+m/2][y]);
        map(x+m/2,y+m/2,m/2,arr[x+m/2][y+m/2]);

    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        map(0,0,n,arr[0][0]);


        System.out.println(cntW+"\n"+cntB);


    }
}