import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int [] arr = new int[10];
        int max = 0;
        int n;

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            int x = Character.getNumericValue(s.charAt(i));
            arr[x] ++;
        }

        for (int i = 0; i < 10; i++) {
            if(i == 9){continue;}
            if(i != 6){ n = arr[i];}
            else {
                n = ((arr[6] + arr[9]) / 2) + ((arr[6] + arr[9]) % 2);
            }
            if(n > max){
                max = n;
            }
        }

        System.out.println(max);


    }
}


