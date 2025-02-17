import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int[] ans = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long ansValue = Long.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];

                if (Math.abs(sum) < Math.abs(ansValue)) {
                    ansValue = sum;
                    ans[0] = arr[i];
                    ans[1] = arr[left];
                    ans[2] = arr[right];
                }

                if (sum == 0) {
                    Arrays.sort(ans);
                    System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
                    return;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        Arrays.sort(ans);
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}
