import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int set = Integer.MAX_VALUE;
        int juice = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int x = Integer.parseInt(br.readLine());
            if(set > x ){
                set = x;
            }
        }

        for (int i = 0; i < 2; i++) {
            int x = Integer.parseInt(br.readLine());
            if (juice > x){
                juice = x;
            }
        }

        System.out.println((set+juice)-50);
    }
}