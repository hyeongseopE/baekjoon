import java.io.*;
import java.util.*;

public class Main {
    static int ans;

    public static int Chk(String value){
        int cnt = 0;
        int left = 0,right = value.length()-1;
        while(left <= right){

            if(value.charAt(left) != value.charAt(right)){
                cnt++;
                break;
            }
            left ++;
            right --;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String []s ;


        int n = Integer.parseInt(br.readLine());
        s = new String[n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            s[i] = input;
            ans = 0;
            int left = 0,right = s[i].length()-1;
            while(left <= right){

                if(s[i].charAt(left) != s[i].charAt(right)){
                    ans ++;
                    String inputLeft = s[i].substring(0,left)+s[i].substring(left+1);
                    String inputRight = s[i].substring(0,right)+s[i].substring(right+1);
                    ans = ans + Math.min(Chk(inputLeft),Chk(inputRight));
                }

                if(ans == 2 || ans == 1){
                    break;
                }
                left ++;
                right --;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}