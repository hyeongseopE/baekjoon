import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        s = br.readLine();
        String best_s = s;
        char max_char = 'A';

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                char[] chars = s.toCharArray();
                if(chars[i] < chars[j] && max_char <= chars[j]){
                    max_char = chars[j];
                    int start = i, end = j;
                    while (start < end) {
                        char temp = chars[start];
                        chars[start] = chars[end];
                        chars[end] = temp;
                        start++;
                        end--;
                    }
                    String s = new String(chars);
                    if (s.compareTo(best_s) > 0) {
                        best_s = s;
                    }
                }
            }
            if(!s.equals(best_s)){break;}
        }
        System.out.println(best_s);


    }
}