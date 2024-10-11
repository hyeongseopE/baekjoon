import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String a = " "+br.readLine();
        String b = " "+br.readLine();

        int [][]Lcs = new int[b.length()+1][a.length()+1];

        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                if(i == 0 || j == 0){
                    Lcs[i][j] = 0;
                }else if(b.charAt(i) == a.charAt(j)){
                    Lcs[i][j] = Lcs[i-1][j-1] + 1;
                }else {
                    Lcs[i][j] = Math.max(Lcs[i-1][j],Lcs[i][j-1]);
                }
            }
        }

        System.out.println(Lcs[b.length()-1][a.length()-1]);
    }
}
