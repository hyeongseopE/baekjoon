import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;
        int [] arr = {1,1,2,2,2,8};

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(arr[i] != x ){
                sb.append(arr[i]-x+" ");
            }else {
                sb.append(0+" ");
            }
        }
        System.out.println(sb);

    }
}