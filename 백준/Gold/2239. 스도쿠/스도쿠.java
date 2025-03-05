import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int [][]map = new int[10][10];
    static boolean [][]rowChk = new boolean[10][10];
    static boolean [][]colChk = new boolean[10][10];
    static boolean [][]boxChk = new boolean[10][10];


    static void back(int y,int x){

        if(x == 9){y++;x=0;}
        if(y == 9){
            for (int i = 0; i < 9 ; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println("");
            }
            System.exit(0);
        }
        if(map[y][x] != 0){
            back(y,x+1);
        }else {
            for (int i = 1; i <= 9; i++) {
                if(!rowChk[x][i] && !colChk[y][i] && !boxChk[y/3*3+x/3][i]){
                    rowChk[x][i]=colChk[y][i]=boxChk[y/3*3+x/3][i]=true;
                    map[y][x] = i;
                    back(y,x+1);
                    rowChk[x][i]=colChk[y][i]=boxChk[y/3*3+x/3][i]=false;
                    map[y][x] = 0;
                }

            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                int num = Character.getNumericValue(input.charAt(j));
                map[i][j] = num;
                if(num != 0){
                    rowChk[j][num] = true;
                    colChk[i][num] = true;
                    boxChk[i/3*3+j/3][num] = true;
                }
            }
        }

        back(0,0);

    }
}


