
import java.io.*;
import java.util.*;

public class Main {
    static long fac (int n ){
        if(n <= 0){
            return 1;
        }
        return n*fac(n-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fac(n));
        
    }
}