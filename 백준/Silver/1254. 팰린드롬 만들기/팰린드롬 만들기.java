import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int x = input.length(); 
        for (int i = 0; i < input.length(); i++) {
           
            if (isPalindrome(input.substring(i))) {
                x += i; 
                break;
            }
        }

        System.out.println(x);
    }

    // 팰린드롬 확인 함수
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
