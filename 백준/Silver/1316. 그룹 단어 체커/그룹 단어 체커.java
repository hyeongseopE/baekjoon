import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        boolean [] answer = new boolean[cnt];
        String [] s = new String[cnt];
        int answercnt = 0;

        for (int i=0;i<cnt;i++){
            answer[i] = true;
        }

        for (int i=0;i<cnt;i++){
            s[i] = br.readLine();
        }

        ArrayList<Character> Ac = new ArrayList<>();
        char c;
        for (int i=0;i<cnt;i++){
            c = s[i].charAt(0);
            Ac.add(c);
            for (int j=0;j<s[i].length();j++){
                if (c == s[i].charAt(j) ){
                    continue;
                }
                if (Ac.contains(s[i].charAt(j)) ){
                    answer[i] = false;
                    break;
                }
                c = s[i].charAt(j);
                Ac.add(s[i].charAt(j));
            }
            Ac.clear();
        }

        for (int i=0;i<cnt;i++){

            if (answer[i] == false) continue;
            answercnt ++;

        }
        System.out.println(answercnt);

    }
}
