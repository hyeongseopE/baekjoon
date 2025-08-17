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

        int x = 0;
        for (int i = 0; i < 4; i++) {
            x += Integer.parseInt(br.readLine());
        }
        if(1800 - x >= 300){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }



    }
}