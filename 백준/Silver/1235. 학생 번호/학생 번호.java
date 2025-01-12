import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String []s  = new String[n+1];
        String []ans = new String[n+1];
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }

        for (int i = 1; i <= s[0].length() ; i++) {
            boolean chk = true;

            for (int j = 0; j < n; j++) {
                ans[j] = s[j].substring(s[j].length()-i);
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(j != k && ans[j].equals(ans[k])){
                        chk = false;
                        break;
                    }
                }
            }
            if(chk){
                System.out.println(i);
                break;
            }
        }

    }
}
