import java.io.*;
import java.util.*;

public class Main {

    static int [][]stack = new int [7][500001];
    static int []top = new int [7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n, m,cnt=0;



        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(top[x] == 0){
                stack[x][++top[x]] = y;
                cnt++;
                
            }else if(stack[x][top[x]] < y){
                stack[x][++top[x]] = y;
                cnt++;
                
            }else if(stack[x][top[x]] > y){
                while(true){
                    
                    if(stack[x][top[x]] == y){
                        break;
                    }else if(stack[x][top[x]] < y){
                        stack[x][++top[x]]=y;
                        cnt++;
                        break;
                    }
                    top[x]--;
                    cnt++;


                }
            }
        }

        System.out.println(cnt);
    }
}