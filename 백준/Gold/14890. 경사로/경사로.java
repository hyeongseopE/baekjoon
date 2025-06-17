import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int n,l;
    static int [][]map;
    static int []slope;   // 1은 아래,왼쪽으로 , 2는 위,오른쪽으로,

    static boolean colMakeSlope(int y, int x, int cnt, int d, int height){

        if(cnt == l && slope[x] == 0){
            slope[x] = d;
            return true;
        }

        if(d==1 && x-1 >= 0 && map[y][x-1] == height && slope[x-1] == 0){
            if(colMakeSlope(y,x-1,cnt+1,d,height)){
                slope[x] = d;
                return true;
            }

        }
        if(d==2 && x+1 < n && map[y][x+1] == height && slope[x+1] == 0) {
            if (colMakeSlope(y, x+1, cnt+1, d, height)) {
                slope[x] = d;
                return true;
            }
        }

        return false;
    }

    static boolean rowMakeSlope(int y, int x, int cnt, int d, int height){

        if(cnt == l && slope[y] == 0){
            slope[y] = d;
            return true;
        }

        if(d==1 && y-1 >= 0 && map[y-1][x] == height && slope[y-1] == 0){
            if(rowMakeSlope(y-1,x,cnt+1,d,height)){
                slope[y] = d;
                return true;
            }

        }
        if(d==2 && y+1 < n && map[y+1][x] == height && slope[y+1] == 0) {
            if (rowMakeSlope(y + 1, x, cnt + 1, d, height)) {
                slope[y] = d;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행 길찾기
        for (int i = 0; i < n; i++) {
            slope = new int[n];
            boolean check = true;
            for (int j = 0; j < n-1; j++) {
                if(map[j][i] < map[j+1][i]){
                    if(map[j+1][i] - map[j][i] > 1){
                        check = false;
                        break;
                    }
                    if(slope[j] == 1){
                        continue;
                    }
                    if(!rowMakeSlope(j,i,1,1,map[j][i])){
                        check = false;
                        break;
                    }
                }
            }

            if(!check){continue;}    // 아래로 가는 길에 경사로를 못 만들어서 브레이크

            for (int j = n-1; j > 0; j--) {
                if(map[j][i] < map[j-1][i]){
                    if(map[j-1][i] - map[j][i] > 1){
                        check = false;
                        break;
                    }
                    if(slope[j] == 2){
                        continue;
                    }
                    if(!rowMakeSlope(j,i,1,2,map[j][i])){
                        check = false;
                        break;
                    }
                }
            }
            if(check){ans++;}
        }

        // 열 길찾기

        for (int i = 0; i < n; i++) {
            slope = new int[n];
            boolean check = true;
            for (int j = 0; j < n-1; j++) {
                if(map[i][j] < map[i][j+1]){
                    if(map[i][j+1] - map[i][j] > 1){
                        check = false;
                        break;
                    }
                    if(slope[j] == 1){
                        continue;
                    }
                    if(!colMakeSlope(i,j,1,1,map[i][j])){
                        check = false;
                        break;
                    }
                }
            }
            if(!check){continue;} // 왼쪽으로 가는 경사로를 못만들면 브레이크

            for (int j = n-1; j > 0; j--) {
                if(map[i][j] < map[i][j-1]){
                    if(map[i][j-1] - map[i][j] > 1){
                        check = false;
                        break;
                    }
                    if(slope[j] == 2){
                        continue;
                    }
                    if(!colMakeSlope(i,j,1,2,map[i][j])){
                        check = false;
                        break;
                    }
                }
            }
            if(check){ans++;}
        }

        System.out.println(ans);

    }
}