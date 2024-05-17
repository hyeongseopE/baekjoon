
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        String s [] = new String[cnt];

        for (int i=0; i< cnt; i++){
            s[i] = br.readLine();
        }
        for (int i=0; i<cnt; i++){
            sb.append(s[i].charAt(0)+""+s[i].charAt(s[i].length()-1)+"\n");
        }
        System.out.println(sb);
    }
}
