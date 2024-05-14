
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Main {
    static class Temp {
        boolean[] check;

        public Temp(String input) {
            check = new boolean[input.length()];
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'B') {
                    this.check[i] = true;
                } else if (input.charAt(i) == 'W') {
                    this.check[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        String[] numbers = number.split(" ");
        int height = Integer.parseInt(numbers[0]);
        int width = Integer.parseInt(numbers[1]);
        int minCount = Integer.MAX_VALUE;

        String[] input = new String[height];
        for (int i = 0; i < height; i++) {
            input[i] = br.readLine();
        }

        for (int ac = 0; ac <= height - 8; ac++) {
            for (int ar = 0; ar <= width - 8; ar++) {
                int cnt = countChanges(input, ac, ar);
                minCount = Math.min(minCount, cnt);
            }
        }

        System.out.println(minCount);
    }

    private static int countChanges(String[] input, int ac, int ar) {
        int cnt = 0;
        boolean check = false;
        for (int i = ac; i < 8 + ac; i++) {
            Temp tmp = new Temp(input[i]);
            check = !check;
            for (int j = ar; j < 8 + ar; j++) {
                if (tmp.check[j] != check) {
                    cnt++;
                }
                check = !check;
            }
        }

        cnt = Math.min(cnt, 64 - cnt);
        return cnt;
    }
}
