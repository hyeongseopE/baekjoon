import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int r,c,ans;
    static int [][]map ;
    static int []chk = new int [26+65];

    static int [][]vitsit ;
    static int []tx = {-1,1,0,0};
    static int []ty = {0,0,-1,1};
    static void back(int x,int y){
        chk[map[x][y]] = 1;
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x+tx[i];
            int ny = y+ty[i];
            if(nx < 0 || nx >= r || ny < 0 || ny >= c){
                cnt ++;
                continue;
            }
            if(vitsit[nx][ny] == 0 && chk[map[nx][ny]] == 0){
                vitsit[nx][ny] = vitsit[x][y]+1;
                back(nx,ny);
                vitsit[nx][ny] = 0;
                chk[map[nx][ny]] = 0;
            }else if(vitsit[nx][ny] != 0 || chk[map[nx][ny]] != 0){
                cnt ++;
            }
        }
        if(cnt == 4){
            ans = Math.max(ans,vitsit[x][y]);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st=new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int [r][c];
        vitsit = new int [r][c];
        for (int i = 0; i < r ; i++) {
            String input = br.readLine();
            for (int j = 0; j < c ; j++) {
                int x = input.charAt(j);
                map[i][j] = x;
            }
        }

        vitsit[0][0] = 1;
        back(0,0);

        System.out.println(ans);



    }
}


