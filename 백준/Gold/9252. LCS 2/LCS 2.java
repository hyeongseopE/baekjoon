import java.io.*;
import java.util.*;

public class Main {

    static int []ty = {-1,0};
    static int []tx = {0,-1};
    static int [][]LCS;
    static String s1;
    static String s2;
    static Stack<Character> ans = new Stack<>();
    static void dfs(int y,int x){

        if(LCS[y][x] == 0){return;}

        if(LCS[y][x] == LCS[y-1][x]){
            dfs(y-1,x);
        }else if (LCS[y][x] == LCS[y][x-1]){
            dfs(y,x-1);
        }else {
            ans.push(s2.charAt(y-1));
            dfs(y-1,x-1);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        s1 = br.readLine();
        s2 = br.readLine();

        LCS = new int[s2.length()+1][s1.length()+1];

        for (int i = 1; i <= s2.length(); i++) {
            char target = s2.charAt(i-1);
            for (int j = 1; j <= s1.length(); j++) {
                if(target == s1.charAt(j-1)){
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                }else {
                    LCS[i][j] = Math.max(LCS[i-1][j],LCS[i][j-1]);
                }
            }
        }

        dfs(s2.length(),s1.length());
        while(!ans.isEmpty()){
            sb.append(ans.pop());
        }

        System.out.println(LCS[s2.length()][s1.length()]+"\n"+sb);




    }
}