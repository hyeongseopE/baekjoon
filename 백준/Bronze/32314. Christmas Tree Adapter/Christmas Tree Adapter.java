import java.io.*;
import java.util.*;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int a = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        System.out.println((w/a) >= v ? 1 : 0 );


    }
}


