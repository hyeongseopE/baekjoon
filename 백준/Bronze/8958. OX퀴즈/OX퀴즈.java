import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int cnt;
        int ans;

        for (int i = 0; i < t ; i++) {
            String input = br.readLine();
            ans=0;
            cnt=0;
            for (int j = 0; j < input.length(); j++) {
                if(input.charAt(j)=='O'){
                    cnt++;
                }
                if(input.charAt(j)=='X'){
                    cnt=0;
                }
                ans += cnt;
            }
            sb.append(ans).append("\n");

        }
        System.out.println(sb);





    }
}


