import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String [][] arr = new String [6][16];
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j <input.length() ; j++) {
                arr[i][j] = Character.toString(input.charAt(j));
            }
        }

        int cnt = 0;
        for (int i = 0; i < arr[0].length ; i++) {
            for (int j = 0; j < 5; j++) {
                if(arr[j][i] == null){
                    continue;
                }
                sb.append(arr[j][i]);
            }
        }

        System.out.println(sb);



    }
}


