
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] s = br.readLine().toCharArray();

        int a = 0;
        int b = 0;

        for (char c : s) {
            if (c == 'A') {
                a++;
            } else {
                b++;
            }
        }

        System.out.println(a +" : "+ b);
    }
}