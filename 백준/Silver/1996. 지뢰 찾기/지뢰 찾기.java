import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int [][]arr1 = new int[n][n];
        int [][]arr2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            char[] c = input.toCharArray();
            for (int j = 0; j < n; j++) {
                if(c[j] == '.'){arr1[i][j] = 0;}
                else{arr1[i][j] = Character.getNumericValue(c[j]);}

            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[i][j] != 0 ){
                    sb.append("*");
                    continue;

                }

                if ((j-1)>=0 && (i-1)>=0 && arr1[i-1][j-1] != 0){
                    arr2[i][j] += arr1[i-1][j-1];
                }
                if ((i-1)>=0 && arr1[i-1][j] != 0){
                    arr2[i][j] += arr1[i-1][j];
                }
                if ((j+1)<n && (i-1)>=0 && arr1[i-1][j+1] != 0){
                    arr2[i][j] += arr1[i-1][j+1];
                }
                if ((j+1)<n && arr1[i][j+1] != 0){
                    arr2[i][j] += arr1[i][j+1];
                }
                if((j+1)<n && (i+1)<n && arr1[i+1][j+1] != 0){
                    arr2[i][j] += arr1[i+1][j+1];
                }
                if((i+1)<n && arr1[i+1][j] != 0){
                    arr2[i][j] += arr1[i+1][j];
                }
                if((i+1)<n && (j-1)>=0 && arr1[i+1][j-1] != 0 ){
                    arr2[i][j] += arr1[i+1][j-1];
                }
                if((j-1)>=0 && arr1[i][j-1] != 0){
                    arr2[i][j] += arr1[i][j-1];
                }
                if (arr2[i][j] >= 10){
                    sb.append("M");
                }else{
                    sb.append(arr2[i][j]);
                }

            }
            sb.append("\n");

        }
        System.out.println(sb);


    }
}